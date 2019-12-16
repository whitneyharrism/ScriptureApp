package com.example.scripturestudyapp;

import android.util.Log;

import com.google.firebase.database.FirebaseDatabase;

/**
 * Quiz that asks the user to rate themselves on Christlike attributes
 * Passed as quiz in quizRunner
 * @author codyl and Whitney
 * @since 12/3/19
 */
public class AttributeQuiz extends ScaleQuiz {
    AttributeQuiz()
    {
        ScaleQuestion q1= new ScaleQuestion("I believe in Christ and accept Him as my Savior", "faith");
        ScaleQuestion q2 = new ScaleQuestion("I feel confident that God loves me","faith");
        ScaleQuestion q3 = new ScaleQuestion("I trust the Savior enough to accept His will and do whatever He asks.","faith");
        ScaleQuestion q4 = new ScaleQuestion("I firmly believe that through the Atonement of Jesus Christ I can be forgiven of all my sins.","faith");
        ScaleQuestion q5 = new ScaleQuestion("I have enough faith in Christ to obtain answers to my prayers.","faith");
        ScaleQuestion q6 = new ScaleQuestion("I think about the Savior during the day and remember what He has done for me.","faith");
        ScaleQuestion q7 = new ScaleQuestion("I have the faith necessary to help make good things happen in my life or the lives of others.","faith");
        ScaleQuestion q8 = new ScaleQuestion("I know by the power of the Holy Ghost that the Book of Mormon is true.","faith");
        ScaleQuestion q9 = new ScaleQuestion("I have enough faith in Christ to accomplish anything He wants me to do—even miracles, if necessary.","faith");
        ScaleQuestion q10 = new ScaleQuestion("I believe that the Holy Ghost will guide me as I go through trials.","faith");
        this.addQuestion(q1,q2,q3,q4,q5,q6,q7,q8,q9,q10);
        //Hope
        ScaleQuestion q11 = new ScaleQuestion("One of my greatest desires is to inherit eternal life in the celestial kingdom of God.","hope");
        ScaleQuestion q12 = new ScaleQuestion("I am confident that I will have a happy and successful mission and/or life.","hope");
        ScaleQuestion q13 = new ScaleQuestion("I feel peaceful and optimistic about the future.","hope");
        ScaleQuestion q14 = new ScaleQuestion("I firmly believe that someday I will dwell with God and become like Him.","hope");
        ScaleQuestion q15 = new ScaleQuestion("I am confident that the trials and difficulties that I am going through is for my own good.","hope");
        ScaleQuestion q16 = new ScaleQuestion("I am trying to find ways to cultivate my hope in the gospel.","hope");
        ScaleQuestion q17 = new ScaleQuestion("I believe that hope is necessary, along with faith and charity.","hope");
        ScaleQuestion q18 = new ScaleQuestion("I trust that the Lord will fulfill His promise to us.","hope");
        ScaleQuestion q19 = new ScaleQuestion("I believe that hope can sustain us through despair.","hope");
        ScaleQuestion q20 = new ScaleQuestion("I believe that hope has the power to fill my life with happiness.","hope");
        this.addQuestion(q11,q12,q13,q14,q15,q16,q17,q18,q19,q20);
        //Charity
        ScaleQuestion q21 = new ScaleQuestion("I feel a sincere desire for the eternal welfare and happiness of other people.","charity");
        ScaleQuestion q22 = new ScaleQuestion("When I pray, I ask for charity—the pure love of Christ. ","charity");
        ScaleQuestion q23 = new ScaleQuestion("I try to understand others’ feelings and see their point of view.","charity");
        ScaleQuestion q24 = new ScaleQuestion("I forgive others who have offended or wronged me. ","charity");
        ScaleQuestion q25 = new ScaleQuestion("I try to help others when they are struggling or discouraged.","charity");
        ScaleQuestion q26 = new ScaleQuestion("When appropriate, I tell others that I love them and care about them.","charity");
        ScaleQuestion q27 = new ScaleQuestion("I look for opportunities to serve other people.","charity");
        ScaleQuestion q28 = new ScaleQuestion("I say positive things about others.","charity");
        ScaleQuestion q29 = new ScaleQuestion("I am kind and patient with others, even when they are hard to get along with.","charity");
        ScaleQuestion q30 = new ScaleQuestion("I find joy in others’ achievements.","charity");
        this.addQuestion(q21,q22,q23,q24,q25,q26,q27,q28,q29,q30);
        //Virtue
        ScaleQuestion q31 = new ScaleQuestion("I am clean and pure in heart.","virtue");
        ScaleQuestion q32 = new ScaleQuestion("I have no desire to do evil but to do good.","virtue");
        ScaleQuestion q33 = new ScaleQuestion("I am dependable—I do what I say I will do.","virtue");
        ScaleQuestion q34 = new ScaleQuestion("I focus on righteous, uplifting thoughts and put unwholesome thoughts out of my mind.","virtue");
        ScaleQuestion q35 = new ScaleQuestion("I repent of my sins and strive to overcome my weaknesses.","virtue");
        ScaleQuestion q36 = new ScaleQuestion("I feel the influence of the Holy Ghost in my life.","virtue");
        ScaleQuestion q37 = new ScaleQuestion("I believe in supporting high moral standards in myself and others.","virtue");
        ScaleQuestion q38 = new ScaleQuestion("I refrain from judging others, no matter the circumstance.","virtue");
        ScaleQuestion q39 = new ScaleQuestion("I stand in defence of my values, even if others belittle me.","virtue");
        ScaleQuestion q40 = new ScaleQuestion("I work to be an example of the believers in every situation.","virtue");
        this.addQuestion(q31,q32,q33,q34,q35,q36,q37,q38,q39,q40);
        //Knowledge
        ScaleQuestion q41 = new ScaleQuestion("I feel confident in my understanding of gospel doctrine and principles.","knowledge");
        ScaleQuestion q42 = new ScaleQuestion("I study the scriptures daily.","knowledge");
        ScaleQuestion q43 = new ScaleQuestion("I thirst to learn more about the gospel and to share it with others.","knowledge");
        ScaleQuestion q44 = new ScaleQuestion("I try to teach others of the gospel doctrines.","knowledge");
        ScaleQuestion q45 = new ScaleQuestion("I try to apply what I have learned in the scriptures in my life.","knowledge");
        ScaleQuestion q46 = new ScaleQuestion("I think of learning more about the gospel through study as an opportunity rather than a burden.","knowledge");
        ScaleQuestion q47 = new ScaleQuestion("I immerse myself in the scriptures to better understand the doctrine.","knowledge");
        ScaleQuestion q48 = new ScaleQuestion("I earnestly seek to understand the truth and find answers to my ScaleQuestions.","knowledge");
        ScaleQuestion q49 = new ScaleQuestion("I receive knowledge and guidance through the Spirit. ","knowledge");
        ScaleQuestion q50 = new ScaleQuestion("I love and cherish the doctrine and principles of the gospel.","knowledge");
        this.addQuestion(q41,q42,q43,q44,q45,q46,q47,q48,q49,q50);
        //Patience
        ScaleQuestion q51 = new ScaleQuestion("I wait patiently for the blessings and promises of the Lord to be fulfilled.","patience");
        ScaleQuestion q52 = new ScaleQuestion("I am able to wait for things without getting upset or frustrated.","patience");
        ScaleQuestion q53 = new ScaleQuestion("I am patient and long-suffering with the challenges of being a missionary.","patience");
        ScaleQuestion q54 = new ScaleQuestion("I am patient with the faults and weaknesses of others. ","patience");
        ScaleQuestion q55 = new ScaleQuestion("I am patient with myself and rely on the Lord as I work to overcome my weaknesses.","patience");
        ScaleQuestion q56 = new ScaleQuestion("I face adversity and afflictions calmly and hopefully. ","patience");
        ScaleQuestion q57 = new ScaleQuestion("I am patient in developing and strengthening my testimony.","patience");
        ScaleQuestion q58 = new ScaleQuestion("I don't expect perfection in myself and others.","patience");
        ScaleQuestion q59 = new ScaleQuestion("I strive to find ways to work out differences between myself and others.","patience");
        ScaleQuestion q60 = new ScaleQuestion("I try to help others when I see them struggle.","patience");
        this.addQuestion(q51,q52,q53,q54,q55,q56,q57,q58,q59,q60);
        //Humility
        ScaleQuestion q61 = new ScaleQuestion("I am meek and lowly in heart.","humility");
        ScaleQuestion q62 = new ScaleQuestion("I rely on the Lord for help.","humility");
        ScaleQuestion q63 = new ScaleQuestion("I am sincerely grateful for the blessings I have received from the Lord.","humility");
        ScaleQuestion q64 = new ScaleQuestion("My prayers are earnest and sincere.","humility");
        ScaleQuestion q65 = new ScaleQuestion("I seek the Lord's strength in hard situations.","humility");
        ScaleQuestion q66 = new ScaleQuestion("I openly acknowledge the accomplishments of others when I can.","humility");
        ScaleQuestion q67 = new ScaleQuestion("I seek the input of others, even if I feel as if I don't need it.","humility");
        ScaleQuestion q68 = new ScaleQuestion("I am willing to be taught when I don't know what to do.","humility");
        ScaleQuestion q69 = new ScaleQuestion("I appreciate direction from my leaders or teachers. ","humility");
        ScaleQuestion q70 = new ScaleQuestion("I strive to be submissive to the Lord’s will, whatever it may be.","humility");
        this.addQuestion(q61,q62,q63,q64,q65,q66,q67,q68,q69,q70);
        //Diligence
        ScaleQuestion q71 = new ScaleQuestion("I work effectively, even when I’m not under pressure or close supervision.","diligence");
        ScaleQuestion q72 = new ScaleQuestion("I focus my efforts on the most important things.","diligence");
        ScaleQuestion q73 = new ScaleQuestion("I have a personal prayer at least twice a day.","diligence");
        ScaleQuestion q74 = new ScaleQuestion("I focus my thoughts on my calling in life.","diligence");
        ScaleQuestion q75 = new ScaleQuestion("I set goals and plan regularly.","diligence");
        ScaleQuestion q76 = new ScaleQuestion("I often get up early to get a head start in my day.","diligence");
        ScaleQuestion q77 = new ScaleQuestion("I often don't let distractions interfere with what is needed to be done.","diligence");
        ScaleQuestion q78 = new ScaleQuestion("I try to learn what God expects of me and follow through.","diligence");
        ScaleQuestion q79 = new ScaleQuestion("I work hard until the job is completed successfully.","diligence");
        ScaleQuestion q80 = new ScaleQuestion("I find joy and satisfaction in my work.","diligence");
        this.addQuestion(q71,q72,q73,q74,q75,q76,q77,q78,q79,q80);
        //Obedience
        ScaleQuestion q81 = new ScaleQuestion("When I pray, I ask for strength to resist temptation and to do what is right.","obedience");
        ScaleQuestion q82 = new ScaleQuestion("I keep the required commandments to be worthy of a temple recommend.","obedience");
        ScaleQuestion q83 = new ScaleQuestion("I willingly obey the mission rules and follow the counsel of my leaders.","obedience");
        ScaleQuestion q84 = new ScaleQuestion("I strive to live in accordance with the laws and principles of the gospel.","obedience");
        ScaleQuestion q85 = new ScaleQuestion("I truly believe that with obedience, comes greater freedom.","obedience");
        ScaleQuestion q86 = new ScaleQuestion("I strive to live the Word of Wisdom.","obedience");
        ScaleQuestion q87 = new ScaleQuestion("I try to honor the Sabbath Day.","obedience");
        ScaleQuestion q88 = new ScaleQuestion("I am willing to pay tithing and know how to.","obedience");
        ScaleQuestion q89 = new ScaleQuestion("I understand that keeping the commandments will lead to greater knowledge of the gospel.","obedience");
        this.addQuestion(q81,q82,q83,q84,q85,q86,q87,q88,q89);

        currentQuestion = questions.peek();
    }

}
