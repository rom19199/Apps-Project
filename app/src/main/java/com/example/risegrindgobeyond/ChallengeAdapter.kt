package com.example.risegrindgobeyond

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.lo_challenges.view.*

class ChallengeAdapter(mCtx: Context, val Challenges: ArrayList<Models>): RecyclerView.Adapter<ChallengeAdapter.ViewHolder>(){
    val  mCtx = mCtx

    class ViewHolder(itemView : View):RecyclerView.ViewHolder(itemView){
        val txtChallengeName = itemView.tvName
        val txtChallengefrec = itemView.tvFrec
        val txtChallengeGoal = itemView.tvGoal
        val txtChallengeDesc = itemView.tvDesc
        val btnUpdate = itemView.btnUpdate
        val btnDelete = itemView.btnDelete

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChallengeAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.lo_challenges ,parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return Challenges.size
    }

    override fun onBindViewHolder(holder: ChallengeAdapter.ViewHolder, position: Int) {
        val challenge : Models = Challenges[position]
        holder.txtChallengeName.text = challenge.ChallengeName
        holder.txtChallengefrec.text = challenge.ChallengeFrec
        holder.txtChallengeGoal.text = challenge.ChallengeGoal
        holder.txtChallengeDesc.text = challenge.ChallengeDesc
    }

}

