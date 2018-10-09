package app.refactoring.com.refactoringretrofit.util;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import app.refactoring.com.refactoringretrofit.bean.ChangeModel;
import app.refactoring.com.refactoringretrofit.bean.TitleModel;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 16/12/08
 *     desc  : Utils初始化相关
 * </pre>
 */
public class Utils {

    private static Context context;

    private Utils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /**
     * 初始化工具类
     *
     * @param context 上下文
     */
    public static void init(Context context) {
        Utils.context = context.getApplicationContext();
    }


    public static ChangeModel getChangeModel() {
        ChangeModel changeModel = new ChangeModel();
        List<ChangeModel.Title> titles = new ArrayList<>();
        ChangeModel.Title title = new ChangeModel.Title();
        List<ChangeModel.Answer> answerList = new ArrayList<>();
        ChangeModel.Answer answer1 = new ChangeModel.Answer();
        answer1.setStrAnswer("1A:我是你的A");
        ChangeModel.Answer answer2 = new ChangeModel.Answer();
        answer2.setStrAnswer("1B:我是你的B");
        ChangeModel.Answer answer3 = new ChangeModel.Answer();
        answer3.setStrAnswer("1C:我是你的C");
        answerList.add(answer1);
        answerList.add(answer2);
        answerList.add(answer3);
        title.setAnswers(answerList);
        titles.add(title);

        ChangeModel.Title title1 = new ChangeModel.Title();
        List<ChangeModel.Answer> answerList1 = new ArrayList<>();
        ChangeModel.Answer answer4 = new ChangeModel.Answer();
        answer4.setStrAnswer("2A:我是你的A");
        ChangeModel.Answer answer5 = new ChangeModel.Answer();
        answer5.setStrAnswer("2B:我是你的B");
        ChangeModel.Answer answer6 = new ChangeModel.Answer();
        answer6.setStrAnswer("2C:我是你的C");
        answerList1.add(answer4);
        answerList1.add(answer5);
        answerList1.add(answer6);
        title1.setAnswers(answerList1);
        titles.add(title1);

        ChangeModel.Title title2 = new ChangeModel.Title();
        List<ChangeModel.Answer> answerList2 = new ArrayList<>();
        ChangeModel.Answer answer7 = new ChangeModel.Answer();
        answer7.setStrAnswer("3A:我是你的A");
        ChangeModel.Answer answer8 = new ChangeModel.Answer();
        answer8.setStrAnswer("3B:我是你的B");
        ChangeModel.Answer answer9 = new ChangeModel.Answer();
        answer9.setStrAnswer("3C:我是你的C");
        answerList2.add(answer7);
        answerList2.add(answer8);
        answerList2.add(answer9);
        title2.setAnswers(answerList2);
        titles.add(title2);


        changeModel.setTitles(titles);
        return changeModel;
    }

    public static TitleModel getTitles() {
        TitleModel titleModel = new TitleModel();
        List<TitleModel.Title> titles = new ArrayList<>();
        TitleModel.Title title = new TitleModel.Title();
        title.setTitle("土豆");
        TitleModel.Title title1 = new TitleModel.Title();
        title1.setTitle("牛肉");
        TitleModel.Title title2 = new TitleModel.Title();
        title2.setTitle("西红柿");
        TitleModel.Title title3 = new TitleModel.Title();
        title3.setTitle("青菜");
        TitleModel.Title title4 = new TitleModel.Title();
        title4.setTitle("胡萝卜");
        titles.add(title);
        titles.add(title1);
        titles.add(title2);
        titles.add(title3);
        titles.add(title4);
        titleModel.setTitleList(titles);
        return titleModel;
    }

    /**
     * 获取ApplicationContext
     *
     * @return ApplicationContext
     */
    public static Context getContext() {
        if (context != null)
            return context;
        throw new NullPointerException("u should init first");
    }


}