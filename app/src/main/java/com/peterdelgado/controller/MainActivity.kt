package com.peterdelgado.controller


import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONException
import khttp.*
import android.os.StrictMode
import android.view.View
import android.app.AlertDialog
import android.support.design.widget.Snackbar
import com.peterdelgado.innocv.R
import com.peterdelgado.model.User



class MainActivity : AppCompatActivity() {
    val User: User = User("4444", "peter", "test")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        fab.setOnClickListener { view ->
            Snackbar.make(view, "Send Email", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

       //REMOVES CONFIG ERROR
        if (android.os.Build.VERSION.SDK_INT > 9) {
            val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
            StrictMode.setThreadPolicy(policy)
        }

        toGet()
        toDelete()
        toPost()
        toUpdate()

    }


    fun toGet() {
        viewBtn.setOnClickListener(
            View.OnClickListener {


                try {
                    val id: String = idTxt.text.toString()

                    //CHECKS TO SEE IF USER HAS ENTERED INPUT, IF NOT GETS ALL
                    if(id.equals("")){
                        val get = get(
                            url = "https://hello-world.innocv.com/api/User"
                        )

                    }
                    //GETS USER BY ID
                    val get = get(
                        url = "https://hello-world.innocv.com/api/User/$id"
                    )
                    val builder = AlertDialog.Builder(this@MainActivity)






                    //CHECKS IF ID IS MISSING FROM DB AND ALERTS DB
                    if(get.statusCode.equals(204))
                    {

                        Toast.makeText(applicationContext,"User Not Found! Try Again",Toast.LENGTH_LONG).show()

                    } else {

                        builder.setTitle("Get Response")
                        builder.setMessage(get.text)
                        val dialog: AlertDialog = builder.create()
                        dialog.show()

                        return@OnClickListener
                    }

                }catch(e: JSONException){}




            }
        )
    }


    fun toDelete(){
        deleteBtn.setOnClickListener {
            try {
                val id: String = idTxt.text.toString()
                val delete = delete(
                    url = "https://hello-world.innocv.com/api/User/$id"
                )
                val builder = AlertDialog.Builder(this@MainActivity)
                builder.setTitle("JSON DELETE RESPONSE")
                builder.setMessage(delete.toString())
                val dialog: AlertDialog = builder.create()
                dialog.show()
                return@setOnClickListener




            }catch (e: Exception){

            }
        }
    }

    fun toPost() {
        insertBtn.setOnClickListener {
            try {

                val id: String = idTxt.text.toString()
                val name: String = nameTxt.text.toString()


                val payload = mapOf("id" to id, "name" to name)
                val post = ("https://hello-world.innocv.com/api/User/")
                val finalPost = post(post, json=payload)


                if(finalPost.statusCode.equals(200)){

                    Toast.makeText(applicationContext,"Post Successful",Toast.LENGTH_LONG).show()

                }
                else{
                    Toast.makeText(applicationContext,"Not Successful",Toast.LENGTH_LONG).show()

                }

                return@setOnClickListener

            }catch (e: Exception){
                e.printStackTrace()

            }
        }
    }

    fun toUpdate() {
        updateBtn.setOnClickListener {
            try {

                val id: String = idTxt.text.toString()
                val name: String = nameTxt.text.toString()
                val birthdate: String = birtdateTxt.text.toString()

                val payload = mapOf("id" to id, "name" to name)
                val put = ("https://hello-world.innocv.com/api/User/")
                val finalPut = put(put, json=payload)


                if(finalPut.statusCode.equals(200)){

                    Toast.makeText(applicationContext,"Put Successful",Toast.LENGTH_LONG).show()

                }
                else{
                    Toast.makeText(applicationContext,"Not Successful",Toast.LENGTH_LONG).show()

                }


                return@setOnClickListener

            }catch (e: Exception){
                e.printStackTrace()

            }
        }
    }




}














