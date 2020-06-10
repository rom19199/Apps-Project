package com.example.risegrindgobeyond

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.risegrindgobeyond.DB.ChallengeDataBase
import com.example.risegrindgobeyond.DB.ChallengeRepository
import com.example.risegrindgobeyond.DB.Challenges
import com.example.risegrindgobeyond.DB.challengeDAO
import com.example.risegrindgobeyond.database.DataBaseQueries
import com.example.risegrindgobeyond.databinding.ActivityChallengeCreationBinding
import kotlinx.android.synthetic.main.activity_challenge__creation.*
import kotlinx.android.synthetic.main.activity_challenge__creation.view.*

class Challenge_Creation : AppCompatActivity() {
    private lateinit var binding: ActivityChallengeCreationBinding
    private lateinit var challengeViewModel: ChallengeViewModel
//    lateinit var ChallengeName : EditText
//    lateinit var ChallengeFrec: EditText
//    lateinit var ChallengeGoal: EditText
//    lateinit var ChallengeDesc : EditText
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_challenge__creation)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_challenge__creation)
        val dao: challengeDAO = ChallengeDataBase.getInstance(application).ChallengeDao
        val repository = ChallengeRepository(dao)
        val factory = ChallengeViewModelFactory(repository)
        challengeViewModel = ViewModelProvider(this, factory).get(ChallengeViewModel::class.java)
        binding.myViewModel = challengeViewModel
        binding.lifecycleOwner = this
        displayChallengeList()
        initRecyclerView()
        challengeViewModel.message.observe(this, Observer {
            it.getContentIfNotHandled()?.let {
                Toast.makeText(this,it,Toast.LENGTH_LONG).show()
            }
        })

    }

    private fun initRecyclerView(){
        binding.challengeRecyclerView.layoutManager = LinearLayoutManager(this)
        displayChallengeList()

    }


//        ChallengeName = findViewById(R.id.editTextChallengeName)
//        ChallengeFrec = findViewById(R.id.editTextFreq)
//        ChallengeGoal = findViewById(R.id.editTextGoal)
//        ChallengeDesc = findViewById(R.id.editTextDesc)

//        buttonConfirm.setOnClickListener(){
//            if(editTextChallengeName.text.isEmpty()){
//                Toast.makeText(this,"Enter Challenge name", Toast.LENGTH_SHORT).show()
//                editTextChallengeName.requestFocus()
//            }else{
//                val challenge = Models()
//                challenge.ChallengeName = editTextChallengeName.text.toString()
//                if(etFreq1.text.isEmpty())
//                    challenge.ChallengeFrec = etFreq1.text.toString()
//                if(etFreq2.text.isEmpty())
//                    challenge.ChallengeFrec = etFreq2.text.toString()
//                if(tvTime1.text.isEmpty())
//                    challenge.ChallengeGoal = tvTime1.text.toString()
//                if(editTextDescription.text.isEmpty())
//                    challenge.ChallengeDesc = editTextDescription.text.toString()
//                ChallengeProgress.dBhandler.addChallenges(this, challenge)
//                ClearEdit()
//                editTextChallengeName.requestFocus()
//
//            }
//
//        }
//        buttonCancel.setOnClickListener(){
//            ClearEdit()
//            finish()
//
//        }
//    }
//
//    private fun ClearEdit(){
//        editTextChallengeName.text.clear()
//        etFreq1.text.clear()
//        etFreq2.text.clear()
//        tvTime1.text.clear()
//        editTextDescription.text.clear()
//
//    }
   // }
    private fun displayChallengeList(){
        challengeViewModel.challenges.observe(this, Observer {
            Log.i("MYTAG",it.toString())
            binding.challengeRecyclerView.adapter = MyRecycleViewAdapter(it,{selectedItem:Challenges->listItemCliked(selectedItem)})
        })


    }

    private fun listItemCliked(challenge:Challenges){
        //Toast.makeText(this,"Challenge name is ${challenge.name}",Toast.LENGTH_LONG).show()
        challengeViewModel.initUpdateandDelete(challenge)
    }
//    fun addChallenge(v:View) {
//        val db = DataBaseQueries(this)
//        val res = db.addChallenge(
//            ChallengeName.text.toString(),
//            ChallengeFrec.text.toString(),
//            ChallengeGoal.text.toString(),
//            ChallengeDesc.text.toString()
//        )
//        if (res > 0) {
//            AlertDialog.Builder(this)
//                .setIcon(R.mipmap.ic_launcher_round)
//                .setTitle("Message")
//                .setMessage("Challenge Added")
//                .setPositiveButton("Ok", null)
//                .show()
//
//        } else {
//            AlertDialog.Builder(this)
//                .setIcon(R.mipmap.ic_launcher_round)
//                .setTitle("Alert")
//                .setMessage("Something is wrong , \n Please Try again")
//                .setPositiveButton("Ok", null)
//                .show()
//
//        }
//
//
//    }
}
