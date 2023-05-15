package com.padm.ambigest.services.firebase

import android.content.Context
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ListenerRegistration
import com.google.firebase.ktx.Firebase
import com.google.firebase.auth.FacebookAuthProvider
import com.google.firebase.auth.FirebaseUser
import com.padm.ambigest.services.firebase.databaseModels.LoginUserModel
import com.padm.ambigest.services.firebase.databaseModels.NewUserModel

//TODO: Need to make this injectable to be according to DependencyInjection
//TODO: Need to create an interface and implement it here

class FirebaseAuthentication(private val context: Context) {
    private lateinit var auth: FirebaseAuth

    fun registerUser(newUserModel: NewUserModel, onComplete: (checker: Boolean) -> Unit){
        auth = Firebase.auth

        auth.createUserWithEmailAndPassword(newUserModel.email, newUserModel.password)
            .addOnCompleteListener{ task ->
                if(task.isSuccessful){
                    //Something here
                    val newUser: FirebaseUser = task.result!!.user!!

                    newUser.sendEmailVerification().addOnCompleteListener{
                        if(it.isSuccessful){
                            Toast.makeText(context, "Verify your email!", Toast.LENGTH_SHORT).show()
                            onComplete(true)
                        }else{
                            Toast.makeText(context, "There was a problem verifying your email.", Toast.LENGTH_SHORT).show()
                            onComplete(false)
                        }
                    }

                    Toast.makeText(context, "Email verification sent!", Toast.LENGTH_LONG).show()
                    onComplete(true)
                }
                else{
                    Toast.makeText(context, task.exception!!.message, Toast.LENGTH_LONG).show()
                    onComplete(false)
                }
            }
    }

    fun loginUser(loginUserModel: LoginUserModel, onComplete: (checker: Boolean) -> Unit){
        auth = Firebase.auth

        auth.signInWithEmailAndPassword(loginUserModel.email, loginUserModel.password)
            .addOnCompleteListener{ task ->
                if(task.isSuccessful){

                    val user = task.result.user

                    if(!user!!.isEmailVerified) {
                        Toast.makeText(context, "Please, verify your email.", Toast.LENGTH_SHORT).show()
                        onComplete(false)
                    }
                    else{
                        onComplete(true)
                    }
                }
                else{
                    onComplete(false)
                }
            }
    }

    fun recoverPassword(email: String, onComplete: (checker: Boolean) -> Unit){
        auth = Firebase.auth

        auth.sendPasswordResetEmail(email)
            .addOnCompleteListener{
                if(it.isSuccessful){
                    onComplete(true)
                }else{
                    onComplete(false)
                }
            }
    }


}