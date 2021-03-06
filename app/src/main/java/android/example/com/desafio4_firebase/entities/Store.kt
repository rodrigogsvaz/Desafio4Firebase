package android.example.com.desafio4_firebase.entities

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.widget.ImageView
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.ktx.storage
import java.io.ByteArrayOutputStream

class Store (val pathString : String,
             val store: FirebaseStorage = Firebase.storage(Credentials().URL),
             val storageRef: StorageReference = store.reference) {


    var imagesRef : StorageReference = storageRef.child(pathString)
    fun uploadFromMemory(imageView : ImageView) : String {
        var imagePath = ""
// Get the data from an ImageView as bytes
        imageView.isDrawingCacheEnabled = true
        imageView.buildDrawingCache()
        val bitmap = (imageView.drawable as BitmapDrawable).bitmap
        val baos = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos)
        val data = baos.toByteArray()

        var uploadTask = imagesRef.putBytes(data)
        uploadTask.addOnFailureListener {
            // Handle unsuccessful uploads
        }.addOnSuccessListener { taskSnapshot ->
            // taskSnapshot.metadata contains file metadata such as size, content-type, etc.
            // ...
            imagePath = taskSnapshot.metadata!!.path!!
        }

        return imagePath
    }
}