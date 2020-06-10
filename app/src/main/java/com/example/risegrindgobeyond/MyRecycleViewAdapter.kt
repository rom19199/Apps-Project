package com.example.risegrindgobeyond

import android.app.LauncherActivity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.risegrindgobeyond.DB.Challenges
import com.example.risegrindgobeyond.databinding.LoChallengesBinding
import com.example.risegrindgobeyond.generated.callback.OnClickListener

class MyRecycleViewAdapter(private val challengesList: List<Challenges>, private val clickListener:(Challenges)->Unit):RecyclerView.Adapter<MyViewHolder> () {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater= LayoutInflater.from(parent.context)
        val binding:LoChallengesBinding =
            DataBindingUtil.inflate(layoutInflater,R.layout.lo_challenges,parent,false)
        return MyViewHolder(binding)

    }

    override fun getItemCount(): Int {
        return challengesList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(challengesList[position],clickListener)
    }


}

class MyViewHolder(val binding:LoChallengesBinding):RecyclerView.ViewHolder(binding.root){
    fun bind(challenge:Challenges,clickListener:(Challenges)->Unit){
        binding.nameTextView.text = challenge.name
        binding.FreqTextView.text = challenge.freq
        binding.goalTextView.text = challenge.goal
        binding.descTextView.text = challenge.desc
        binding.listItemLayout.setOnClickListener{
            clickListener(challenge)
        }

    }
}