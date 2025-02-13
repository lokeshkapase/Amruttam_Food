package com.lokesh.amruttam_food

import android.credentials.GetCredentialRequest
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.credentials.CredentialManager
import androidx.credentials.GetCredentialResponse
import com.google.android.libraries.identity.googleid.GetGoogleIdOption
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.core.Context
import kotlinx.coroutines.CancellationException

class Sign_In_Activity(private val context: Context)
{
    private val tag = "GoogleSignInClient: "
    private val credentialManager = CredentialManager.create(context)
    private val firebaseAuth = FirebaseAuth.getInstance()

    fun isSignedIn(): Boolean {

    }

    suspend fun signIn(): Boolean {
        if(isSignedIn()){
            return true
        }
        try{


        }catch (e: Exception){
            e.printStackTrace()
            if(e is CancellationException) throw e
            println(tag + "Sign in error: ${e.message}")
            return false
        }
    }


    private suspend fun getCredentialRequest(): GetCredentialResponse{
        val request = GetCredentialRequest.Builder()
            .addCredentialOption(
                GetGoogleIdOption.Builder()
                    .setFilterByAuthorizedAccounts(false)
                    .setServerClientId(
                        ""
                    )
                    .setAutoSelectEnabled(false)
                    .build()
            )
            .build()
        return credentialManager.getCredential(
            request = request,context=context
        )
    }

    fun SignOut(){

    }
}