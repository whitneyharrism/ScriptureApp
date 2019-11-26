package com.example.scripturestudyapp;

public class AttributeQuiz{
    Quiz quiz;
    AttributeQuiz()
    {
        Question q1= new Question("I believe in Christ and accept Him as my Savior", "faith");
        Question q2 = new Question("I feel confident that God loves me","faith");
        Question q3 = new Question("I trust the Savior enough to accept His will and do whatever He asks.","faith");
        Question q4 = new Question("I firmly believe that through the Atonement of Jesus Christ I can be forgiven of all my sins.","faith");
        Question q5 = new Question("I have enough faith in Christ to obtain answers to my prayers.","faith");
        Question q6 = new Question("I think about the Savior during the day and remember what He has done for me.","faith");
        Question q7 = new Question("I have the faith necessary to help make good things happen in my life or the lives of others.","faith");
        Question q8 = new Question("I know by the power of the Holy Ghost that the Book of Mormon is true.","faith");
        Question q9 = new Question("I have enough faith in Christ to accomplish anything He wants me to do—even miracles, if necessary.","faith");
        Question q10 = new Question("I believe that the Holy Ghost will guide me as I go through trials.","faith");
        quiz.addQuestion(q1,q2,q3,q4,q5,q6,q7,q8,q9,q10);
        //Hope
        Question q11 = new Question("One of my greatest desires is to inherit eternal life in the celestial kingdom of God.","hope");
        Question q12 = new Question("I am confident that I will have a happy and successful mission and/or life.","hope");
        Question q13 = new Question("I feel peaceful and optimistic about the future.","hope");
        Question q14 = new Question("I firmly believe that someday I will dwell with God and become like Him.","hope");
        Question q15 = new Question("I am confident that the trials and difficulties that I am going through is for my own good.","hope");
        Question q16 = new Question("I am trying to find ways to cultivate my hope in the gospel.","hope");
        Question q17 = new Question("I believe that hope is necessary, along with faith and charity.","hope");
        Question q18 = new Question("I trust that the Lord will fulfill His promise to us.","hope");
        Question q19 = new Question("I believe that hope can sustain us through despair.","hope");
        Question q20 = new Question("I believe that hope has the power to fill my life with happiness.","hope");
        quiz.addQuestion(q11,q12,q13,q14,q15,q16,q17,q18,q19,q20);
        //Charity
        Question q21 = new Question("I feel a sincere desire for the eternal welfare and happiness of other people.","charity");
        Question q22 = new Question("When I pray, I ask for charity—the pure love of Christ. ","charity");
        Question q23 = new Question("I try to understand others’ feelings and see their point of view.","charity");
        Question q24 = new Question("I forgive others who have offended or wronged me. ","charity");
        Question q25 = new Question("I try to help others when they are struggling or discouraged.","charity");
        Question q26 = new Question("When appropriate, I tell others that I love them and care about them.","charity");
        Question q27 = new Question("I look for opportunities to serve other people.","charity");
        Question q28 = new Question("I say positive things about others.","charity");
        Question q29 = new Question("I am kind and patient with others, even when they are hard to get along with.","charity");
        Question q30 = new Question("I find joy in others’ achievements.","charity");
        quiz.addQuestion(q21,q22,q23,q24,q25,q26,q27,q28,q29,q30);
        //Virtue
        Question q31 = new Question("I am clean and pure in heart.","virtue");
        Question q32 = new Question("I have no desire to do evil but to do good.","virtue");
        Question q33 = new Question("I am dependable—I do what I say I will do.","virtue");
        Question q34 = new Question("I focus on righteous, uplifting thoughts and put unwholesome thoughts out of my mind.","virtue");
        Question q35 = new Question("I repent of my sins and strive to overcome my weaknesses.","virtue");
        Question q36 = new Question("I feel the influence of the Holy Ghost in my life.","virtue");
        Question q37 = new Question("I believe in supporting high moral standards in myself and others.","virtue");
        Question q38 = new Question("I refrain from judging others, no matter the circumstance.","virtue");
        Question q39 = new Question("I stand in defence of my values, even if others belittle me.","virtue");
        Question q40 = new Question("I work to be an example of the believers in every situation.","virtue");
        quiz.addQuestion(q31,q32,q33,q34,q35,q36,q37,q38,q39,q40);
        //Knowledge
        Question q41 = new Question("I feel confident in my understanding of gospel doctrine and principles.","knowledge");
        Question q42 = new Question("I study the scriptures daily.","knowledge");
        Question q43 = new Question("I thirst to learn more about the gospel and to share it with others.","knowledge");
        Question q44 = new Question("I try to teach others of the gospel doctrines.","knowledge");
        Question q45 = new Question("I try to apply what I have learned in the scriptures in my life.","knowledge");
        Question q46 = new Question("I think of learning more about the gospel through study as an opportunity rather than a burden.","knowledge");
        Question q47 = new Question("I immerse myself in the scriptures to better understand the doctrine.","knowledge");
        Question q48 = new Question("I earnestly seek to understand the truth and find answers to my questions.","knowledge");
        Question q49 = new Question("I receive knowledge and guidance through the Spirit. ","knowledge");
        Question q50 = new Question("I love and cherish the doctrine and principles of the gospel.","knowledge");
        quiz.addQuestion(q41,q42,q43,q44,q45,q46,q47,q48,q49,q50);
        //Patience
        Question q51 = new Question("I wait patiently for the blessings and promises of the Lord to be fulfilled.","patience");
        Question q52 = new Question("I am able to wait for things without getting upset or frustrated.","patience");
        Question q53 = new Question("I am patient and long-suffering with the challenges of being a missionary.","patience");
        Question q54 = new Question("I am patient with the faults and weaknesses of others. ","patience");
        Question q55 = new Question("I am patient with myself and rely on the Lord as I work to overcome my weaknesses.","patience");
        Question q56 = new Question("I face adversity and afflictions calmly and hopefully. ","patience");
        Question q57 = new Question("I am patient in developing and strengthening my testimony.","patience");
        Question q58 = new Question("I don't expect perfection in myself and others.","patience");
        Question q59 = new Question("I strive to find ways to work out differences between myself and others.","patience");
        Question q60 = new Question("I try to help others when I see them struggle.","patience");
        quiz.addQuestion(q51,q52,q53,q54,q55,q56,q57,q58,q59,q60);
        //Humility
        Question q61 = new Question("I am meek and lowly in heart.","humility");
        Question q62 = new Question("I rely on the Lord for help.","humility");
        Question q63 = new Question("I am sincerely grateful for the blessings I have received from the Lord.","humility");
        Question q64 = new Question("My prayers are earnest and sincere.","humility");
        Question q65 = new Question("I seek the Lord's strength in hard situations.","humility");
        Question q66 = new Question("I openly acknowledge the accomplishments of others when I can.","humility");
        Question q67 = new Question("I seek the input of others, even if I feel as if I don't need it.","humility");
        Question q68 = new Question("I am willing to be taught when I don't know what to do.","humility");
        Question q69 = new Question("I appreciate direction from my leaders or teachers. ","humility");
        Question q70 = new Question("I strive to be submissive to the Lord’s will, whatever it may be.","humility");
        quiz.addQuestion(q61,q62,q63,q64,q65,q66,q67,q68,q69,q70);
        //Diligence
        Question q71 = new Question("I work effectively, even when I’m not under pressure or close supervision.","diligence");
        Question q72 = new Question("I focus my efforts on the most important things.","diligence");
        Question q73 = new Question("I have a personal prayer at least twice a day.","diligence");
        Question q74 = new Question("I focus my thoughts on my calling in life.","diligence");
        Question q75 = new Question("I set goals and plan regularly.","diligence");
        Question q76 = new Question("I often get up early to get a head start in my day.","diligence");
        Question q77 = new Question("I often don't let distractions interfere with what is needed to be done.","diligence");
        Question q78 = new Question("I try to learn what God expects of me and follow through.","diligence");
        Question q79 = new Question("I work hard until the job is completed successfully.","diligence");
        Question q80 = new Question("I find joy and satisfaction in my work.","diligence");
        quiz.addQuestion(q71,q72,q73,q74,q75,q76,q77,q78,q79,q80);
        //Obedience
        Question q81 = new Question("When I pray, I ask for strength to resist temptation and to do what is right.","obedience");
        Question q82 = new Question("I keep the required commandments to be worthy of a temple recommend.","obedience");
        Question q83 = new Question("I willingly obey the mission rules and follow the counsel of my leaders.","obedience");
        Question q84 = new Question("I strive to live in accordance with the laws and principles of the gospel.","obedience");
        Question q85 = new Question("I truly believe that with obedience, comes greater freedom.","obedience");
        Question q86 = new Question("I strive to live the Word of Wisdom.","obedience");
        Question q87 = new Question("I try to honor the Sabbath Day.","obedience");
        Question q88 = new Question("I am willing to pay tithing and know how to.","obedience");
        Question q89 = new Question("I understand that keeping the commandments will lead to greater knowledge of the gospel.","obedience");
        quiz.addQuestion(q81,q82,q83,q84,q85,q86,q87,q88,q89);

    }

}
