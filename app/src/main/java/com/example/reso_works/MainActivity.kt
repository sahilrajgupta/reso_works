package com.example.reso_works



import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.grid_item.*
import kotlinx.android.synthetic.main.popup_window.*
import kotlinx.android.synthetic.main.popup_window.view.*

class MainActivity : AppCompatActivity(), PopUpGrid.OnItemClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        popup.setOnClickListener{
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
        popup.adapter = PopUpGrid(gridList,this)
        popup.layoutManager = GridLayoutManager(this, 2,GridLayoutManager.HORIZONTAL,false)
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

            val item1 = GridItem(" Register your dispute","Register your case at our platform to find a non-confrontational solution to your dispute.\n" +
                    "\n" +
                    "1 If you want to take advice from a facilitator (Experience DRP ) who will facilitate you to decide further course of action regarding your dispute.\n" +
                    "2 You can choose Facilitator out of experienced DRP listed on portal depending requirement of your case and location etc.\n" +
                    "3 On advice of facilitator (DRP) or without help of facilitator you can further decide to go for Arbitration/Mediations.")
            list +=item1

            val item2 = GridItem("Choose Arbitrator / Mediator","Choose from our arbitrator/ Mediator for your dispute as per the availability in your desired location.")

            list +=item2

            val item3 = GridItem("Invite the 2nd Party","In the next step, a formal arbitration letter will be sent to the party, inviting them to join in to resolve the dispute in a more flexible and time-efficient way. You may approach the other party to come to the platform in order to make the process complete quickly.")

            list +=item3

            val item4 = GridItem("Agree on Arbitrator/Mediator in your location","1 After both parties give mutual consent to proceed with the process of dispute resolution, they have to now choose an arbitrator depending upon the business involved in the dispute.\n" +
                    "2 This step culminates when parties pick an arbitrator from our panel. In case, there are differences over selection of the arbitrator a scenario is provided to choose arbitrator/ mediator through an algorithm to select independent DRP , certain other filters are provided in the system, on the basis of their fields of expertise, location, budget, etc.\n" +
                    "3 Using these filters, both parties would pick some arbitrators/ mediator of their choice independently and then our patented algorithms would decide the arbitrator/ mediator independently for the dispute resolution.")

            list +=item4

            val item5 = GridItem("Finalizing the Arbitrator/Mediator","The algorithms in our technology finalize the best DRP following submission of parties' preferences. Later, the arbitrator is notified about your case. Now, both parties will be asked to pay charges of the arbitration/ mediation.")

            list +=item5

            val item6 = GridItem("Set Your Time of Hearing","Unlike the legal battle in courts, you get quick resolution of disputes on the internet platform. The arbitrator/ mediator , you mutually agreed upon will now set the hearing date.")

            list +=item6

            val item7 = GridItem("Arguments & Evidence","1 Both parties are required to submit documents online to make it easy for the arbitrator/ mediator to understand your case. Documents can also be submitted at the time of the first hearing.\n" +
                    "2 After you are done with the payment and documentation, the arbitrator/ mediator will now set the venue for the hearing. Both parties should present physically if they belong to the same or neighbouring cities. They may also join the hearings by video conferencing.")

            list +=item7

            val item8 = GridItem("Dispute Resolved","1 Mediator shall try to finalise a mutual settlement agreement between all the parties and the same shall be signed by the concerned parties , in case mutual settlement could not be agreed between the parties , they may decide to go for arbitration or may file a court case. The mediation process may complete with or without meeting between parties depending on complexity of case.\n" +
                    "2 In case of arbitration, It will be our endeavour that the arbitrator passes fair judgment within one or two hearings. However, there may be several hearings depending on the complexity of the cases. Final Award shall be passed by arbitrator as per provisions of law.")

            list +=item8
        return list
    }

    override fun onClick(position: Int) {
        /*val mDialogView = LayoutInflater.from(this).inflate(R.layout.popup_window,null);
        val list = generateGridList()
        //description.setText(list[position].desc)
        val mBuilder = AlertDialog.Builder(this)
            .setView(mDialogView)
            .setTitle("Description")
            .setMessage(list[position].desc)
        val mAlertDialog = mBuilder.show()

        mDialogView.close.setOnClickListener{
            mAlertDialog.dismiss()*/
        val list = generateGridList()
        val bottomSheet = BottomSheet(list,position)
        bottomSheet.show(supportFragmentManager,"BottomSheet")
    }
}