package myapplication.t.example.com.demo2048;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import myapplication.t.example.com.demo2048.clss.GrideView;
import myapplication.t.example.com.demo2048.util.DBTools;

public class MainActivity extends Activity implements View.OnClickListener {
    private TextView tvScore;
    private static MainActivity mainActivity = null;
    private int score = 0;
    private Button bt_restart, bt_paihang;
    private GrideView grideView;
    private DBTools dbTools = new DBTools(this);
    private List<Integer> list;


    public MainActivity() {
        mainActivity = this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvScore = (TextView) findViewById(R.id.tvScore);
        bt_restart = (Button) findViewById(R.id.bt_restart);
        grideView = (GrideView) findViewById(R.id.gameView);
        bt_paihang = (Button) findViewById(R.id.bt_paihang);
        bt_paihang.setOnClickListener(this);
        bt_restart.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public static MainActivity getMainActivity() {
        return mainActivity;
    }

    public void clearScore() {

        score = 0;
        showScore();
    }

    public void showScore() {
        tvScore.setText(score + "");
    }

    public void addScore(int s) {
        score += s;
        showScore();

    }

    public int getScore() {
        return score;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_restart:
                grideView.RestartGame();
                break;
            case R.id.bt_paihang:
               int [] grade= getpaihang();
                String[] strings;
                if (grade.length<=10){
                    strings = new String[grade.length];
                }else {
                    strings=new String[10];
                }
                for (int i=0;i<grade.length&&i<10;i++){
                    strings[i]=grade[i]+"";
                }
                //dialog参数设置
                AlertDialog.Builder builder = new AlertDialog.Builder(this);  //先得到构造器
                builder.setTitle("排行榜"); //设置标题
                //builder.setMessage("是否确认退出?"); //设置内容
                builder.setIcon(R.mipmap.ic_launcher);//设置图标，图片id即可
                //设置列表显示，注意设置了列表显示就不要设置builder.setMessage()了，否则列表不起作用。
                builder.setItems(strings, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();

                    }
                });

                builder.create().show();


                break;

        }

    }

    private int[]  getpaihang(){
      List list=  dbTools.getGrade();
        int[] grade=new int[list.size()];
        for (int i=0;i<list.size();i++){
            grade[i]= (int) list.get(i);
        }
        bubbleSort(grade);

        return grade;

    }

    /**
     * 冒泡排序
     * @param a
     */
    public void bubbleSort(int a[]) {

        int n = a.length;

        for (int i = 0; i < n - 1; i++) {

            for (int j = 0; j < n - 1; j++) {

                if (a[j] < a[j + 1]) {

                    int temp = a[j];

                    a[j] = a[j + 1];

                    a[j + 1] = temp;

                }

            }

        }

    }
}
