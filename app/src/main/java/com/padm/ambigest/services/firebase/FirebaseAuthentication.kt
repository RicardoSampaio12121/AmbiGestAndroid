package com.padm.ambigest.services.firebase

import android.content.Context
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ListenerRegistration
import com.google.firebase.ktx.Firebase
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
                    Toast.makeText(context, "user created", Toast.LENGTH_LONG).show()
                    onComplete(true)
                }
                else{
                    Toast.makeText(context, task.exception!!.message, Toast.LENGTH_LONG).show()
                    onComplete(false)
                }
            }
            .addOnFailureListener{
                Toast.makeText(context, it.message, Toast.LENGTH_LONG).show()
                onComplete(false)
            }
    }
}