package com.example.reso_works



import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.grid_item.*
import kotlinx.android.synthetic.main.popup_window.*
import kotlinx.android.synthetic.main.popup_window.view.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        open.setOnClickListener{
            val mDialogView = LayoutInflater.from(this).inflate(R.layout.popup_window,null);

            val mBuilder = AlertDialog.Builder(this)
                .setView(mDialogView)
                .setTitle("Description")
            val mAlertDialog = mBuilder.show()

            mDialogView.close.setOnClickListener{
                mAlertDialog.dismiss()
            }

        }

        val faqList = generateFaqList()
        recycler_view.adapter = FaqAdapter(faqList)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.setHasFixedSize(true)

        val gridList = generateGridList()
        popup.adapter = PopUpGrid(gridList)
        popup.layoutManager = GridLayoutManager(this, 5,GridLayoutManager.VERTICAL,false)
        popup.setHasFixedSize(true)
    }

    private fun generateFaqList():List<FaqItem> {
       val list = ArrayList<FaqItem>()
            val item1 = FaqItem("1. What is Arbitration?", "Arbitration is a form of alternative dispute resolution in which a person can resolve a conflict without going to court. In Arbitration a dispute is submitted, by agreement of the parties, to one or more arbitrators who make a binding decision on the dispute. Arbitration process in India is governed by the Arbitration and Conciliation Act, 1996 and its amendment in 2015.")
            //list = (list + item1) as ArrayList<FaqItem>
            list += item1
            val item2 = FaqItem(" 2. What is Mediation? ", "Mediation is a procedure in which the parties discuss their disputes with the assistance of a trained impartial third person(s) who assists disputing parties in resolving conflict through the use of specialized communication and negotiation techniques.")
            list += item2
            val item3 = FaqItem(" 3. What is the benefit of aggrieved party using the Reso Platform? ","Reso is a first of its kind unique online platform to settle your disputes, whether big or small, in an easy, effective, transparent and inexpensive way. The platform gives you the option to look for neutral and expert arbitrators and mediators to help resolve your disputes in a structured manner which saves you the hassles of researching and setting up the process in traditional offline mode.")
            list +=item3
            val item4 = FaqItem(" 4. What is the size of case required by a party to register on the platform? ","Reso works effectively for all sizes of cases, whether big or small, there is no size limit. Unlike, traditional process for Arbitration and Mediation, we are geared for smaller disputes to be addressed at reasonable cost and without the need for necessarily hiring experienced advocates.")
            list +=item4
            val item5 = FaqItem(" 5. What if the second party does not respond to the arbitration/ mediation process through the platform? ","If you have an arbitration clause in your agreement then it is mandatory for the second party to respond as per the terms of this arbitration clause. If you do not have such arbitration clause or you opt for mediation, then the process can be taken forward only if both parties consent to such process. This is same situation whether one uses the portal or not, but the portal will help the first party in convincing the second party to join the process.")
            list +=item5
            val item6 = FaqItem(" 6. Who can be a member of the community of arbitrators/mediators on Reso Platform? ","Any expert in their domain with good techo-commercial/ legal experience and knowledge can be a part of it. The expert need not be only from the legal world and assistance shall be available on commercial basis for any level of support required by the arbitrator/ mediator. Of course, experienced persons from judicial and/ or advocacy background are most welcome.")
            list +=item6
            val item7 = FaqItem(" 7. How do I select an arbitrator or mediator? ","Once you have registered a case and its details, the platform gives you unique and easy to use online options for selection of arbitrators or mediators based on your requirements and comfort levels. After you have selected the scenario for arbitrator/ mediator selection and the other party has also registered, you and the other party will have options to choose from a wide list of arbitrators/mediators of different expertise, experience and cost. The system is designed for avoiding, as far as possible, the situation of hiring three arbitrators without compromising on the neutrality of the single arbitrator, which will substantially reduce the arbitrators fee.")
            list +=item7
            val item8 = FaqItem(" 8. What is the legal sanctity of Reso platform? ","Reso platform is facilitator for arbitration and mediation albeit with innovations to make the process easy, transparent, amenable for small disputes, etc. The actual processes of arbitration and mediation are to be conducted by the arbitrator/ mediator as per the laws of the land. Therefore, the outcomes of the arbitration and mediation carried out through Reso shall have full legal sanctity, same as it would have in traditional offline process.")
            list +=item8
            val item9 = FaqItem(" 9. How much time & cost does it take for the arbitration or mediation process? ","The arbitration and mediation process typically conclude within 12 months and 3 months respectively after it commences but it shall vary for the specific case. But through Reso Platform the process is eased out through a quicker online methodology thereby reducing the overall time required. The cost of the arbitrators/ mediators shall vary but the transparency and variety offered makes it easy to select an effective but lower cost process, thus reducing the cost.")
            list +=item9
        return list
    }
    private fun generateGridList():List<GridItem>{
        val list = ArrayList<GridItem>()
        for(i in 0 until 10){
            val item = GridItem("Item Title $i","Item Descrpition $i")
            list +=item
        }
        return list
    }
}