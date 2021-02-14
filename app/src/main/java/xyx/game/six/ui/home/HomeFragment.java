package xyx.game.six.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.TreeSet;

import xyx.game.six.Data.Data;
import xyx.game.six.Nums;
import xyx.game.six.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    int a[][]= Data.a;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        //final TextView textView = root.findViewById(R.id.text_home);
        //textView.setVisibility(View.INVISIBLE);
        final TextView textView=root.findViewById(R.id.textView2);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });



        Button button=root.findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(getResult(1));
            }
        });


        Button button2=root.findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                ArrayList<Integer> list=new ArrayList<>();
//                for (int i = 1; i <=49 ; i++) {
//                    list.add(i);
//                }
//             setstr(list);
                String string=getstr(a);
                for (int i = 0; i <=10 ; i++) {
                    string+= "\n"+(i+8)+"预测"+ stoi(getstr(a,i,1))+"="+ stoi(getstr(a,i,1)).size();
                }
//                string+= "\n8预测"+ stoi(getstr(a,0,1))+"="+ stoi(getstr(a,0,1)).size();
//                string+= "\n9预测"+ stoi(getstr(a,1,1))+"="+ stoi(getstr(a,1,1)).size();
//                string+= "\n10预测"+ stoi(getstr(a,2,1))+"="+  stoi(getstr(a,2,1)).size();
//                string+= "\n11预测"+ stoi(getstr(a,3,1))+"="+  stoi(getstr(a,3,1)).size();
//                string+= "\n12预测"+ stoi(getstr(a,4,1))+"="+  stoi(getstr(a,4,1)).size();
//                string+= "\n13预测"+ stoi(getstr(a,5,1))+"="+  stoi(getstr(a,5,1)).size();
//                string+= "\n14预测"+stoi( getstr(a,6,1))+"="+  stoi(getstr(a,6,1)).size();
//                string+="\n15预测"+  stoi(getstr(a,7,1))+"="+ stoi(getstr(a,7,1)).size();
//                string+= "\n16预测"+ stoi(getstr(a,8,1))+"="+ stoi(getstr(a,8,1)).size();
//                string+= "\n17预测"+ stoi(getstr(a,9,1))+"="+ stoi(getstr(a,9,1)).size();
//                string+="\n18预测"+  stoi(getstr(a,10,1))+"="+ stoi(getstr(a,10,1)).size();


                for (int i = 0; i < 10; i++) {
                    string+= "\n"+(i+8)+"测中"+
                            zhongjian(new ArrayList<Integer>(Arrays.asList(a[i+7][0],a[i+7][1],
                                    a[i+7][2],a[i+7][3],a[i+7][4],a[i+7][5],a[i+7][6])),stoi(getstr(a,i,1)))
                            +sayResult(stoi(getstr(a,i,1)),a[i+7][6])+a[i+7][6];
                }
//                string+= "\n8测中"+ zhongjian(new ArrayList<Integer>(Arrays.asList(a[7][0],
//                        a[7][1],a[7][2],a[7][3],a[7][4],a[7][5],a[7][6])),stoi(getstr(a,0)));

                textView.setText(string);

            }
        });


        Button bt3=root.findViewById(R.id.button3);
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string=getstr(a);
                for (int i = 0; i <=10 ; i++) {

                    string+="\n"+(i+8)+"预测"+ threekill(a,i).toString()+"="+threekill(a,i).size();

                }
                for (int i = 0; i <10 ; i++) {

                    string+= "\n"+(i+8)+"测中"+
                            zhongjian(new ArrayList<Integer>(Arrays.asList(a[i+7][0],a[i+7][1],
                                    a[i+7][2],a[i+7][3],a[i+7][4],a[i+7][5],a[i+7][6])),threekill(a,i))
                            +sayResult(threekill(a,i),a[i+7][6])+a[i+7][6];

                }

                textView.setText(string);
            }
        });



        Button bt4=root.findViewById(R.id.button4);
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string=getstr(a);
                for (int i = 0; i <=10 ; i++) {

                    string+="\n"+(i+8)+"预测"+ threekill2(a,i).toString()+"="+threekill2(a,i).size();

                }
                for (int i = 0; i <10 ; i++) {

                    string+= "\n"+(i+8)+"测中"+
                            zhongjian(new ArrayList<Integer>(Arrays.asList(a[i+7][0],a[i+7][1],
                                    a[i+7][2],a[i+7][3],a[i+7][4],a[i+7][5],a[i+7][6])),threekill2(a,i))
                            +sayResult(threekill2(a,i),a[i+7][6])+a[i+7][6];

                }

                textView.setText(string);
            }
        });



        Button bt5=root.findViewById(R.id.button5);
        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(getResult(0));
            }
        });


        Button bt6=root.findViewById(R.id.button6);
        bt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(getResult(2));

            }
        });

        Button bt7=root.findViewById(R.id.button7);
        bt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(getResult(3));

            }
        });
        Button bt8=root.findViewById(R.id.button8);
        bt8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(getResult(4));

            }
        });



        return root;
    }


    private String sayResult(ArrayList<Integer> list, int result){
        String str="不中";
        for (int i = 0; i <list.size() ; i++) {
            if (list.get(i)==result) str="中";
        }
        return str;
    }

    // 算法1合并算法2 去除高频率
    private ArrayList<Integer>  threekill(int a[][],int b){

        ArrayList<Integer> a1=first(a,b,1);
        ArrayList<Integer> a2=stoi(getstr(a,b,1));
        ArrayList<Integer> a3=kill3(a,b);
        // ArrayList<Integer> a4=kill0(a,b);
        a1.addAll(0,a2);
        ArrayList<Integer> newList = new ArrayList<Integer>(new TreeSet<>(a1));//去重并且按照自然顺序排列
        newList.removeAll(a3);
        // newList.removeAll(a4);
        return  newList;

    }
    // 算法1合并算法2 去除高频率+去除冷频率
    private ArrayList<Integer>  threekill2(int a[][],int b){

        ArrayList<Integer> a1=first(a,b,1);
        ArrayList<Integer> a2=stoi(getstr(a,b,1));
        ArrayList<Integer> a3=kill3(a,b);
        ArrayList<Integer> a4=kill0(a,b);
        a1.addAll(0,a2);
        ArrayList<Integer> newList = new ArrayList<Integer>(new TreeSet<>(a1));//去重并且按照自然顺序排列
        newList.removeAll(a3);
        newList.removeAll(a4);
        return  newList;

    }

    //中奖匹配 结果+预测
    private ArrayList<Integer> zhongjian(ArrayList<Integer> result ,ArrayList<Integer> yuce){
        ArrayList<Integer> integers=new ArrayList<>();
        for (int i = 0; i <result.size() ; i++) {
            for (int j = 0; j <yuce.size(); j++) {
                if (result.get(i)==yuce.get(j))integers.add(yuce.get(j));
            }

        }
        return integers;
    }



    private String getResult(int time){
        String str="";

        str=getstr(a);

        for (int i = 0; i <10; i++) {
            str+="\n"+(i+8)+"期预测"+first(a,i,time).toString()+"="+first(a,i,time).size();

            //str+=then1(a,i);
            // str+=then2(a,i);
        }

        str+="\n"+(18)+"期预测"+first(a,10,time).toString()+"="+first(a,10,time).size();

        int alltime=0;
        for (int i = 0; i <10; i++) {
            if (sayResult(first(a,i,time),a[i+7][6]).equals("中"))alltime++;
            str+="\n"+(i+8)+"期测中"+zhongjian(new ArrayList<Integer>(Arrays.asList(a[i+7][0],a[i+7][1],
                    a[i+7][2],a[i+7][3],a[i+7][4],a[i+7][5],a[i+7][6])),first(a,i,time))
                    +sayResult(first(a,i,time),a[i+7][6])+a[i+7][6];
            //str+=then1(a,i);
            // str+=then2(a,i);
        }
        str+="\n合计总中次数"+alltime+"/10";
        return str;
    }


    private String getstr(int[][] a){
        String str="";
        for (int i = 0; i <a.length ; i++) {
            str+="\n第"+(i+1)+"期";
            for (int j = 0; j <a[i].length ; j++) {
                str+="["+a[i][j]+"]";
            }
        }
        return str;
    }

    //计算
    private ArrayList<Integer>  first(int [][] a,int b,int time){

        ArrayList<Integer> list=new ArrayList<>();
        for (int i = b; i < b+7; i++) {
            for (int j = 0; j <7 ; j++) {
                list.add(a[i][j]);

            }
        }

        Collections.sort(list);//默认排序(从小到大)

        // System.out.println(list.size()+list.toString());

        ArrayList<Integer> list2=new ArrayList();

        for (int i = 1; i <=49; i++) {
            //System.out.println((i+1)+"="+ Collections.frequency(list, i+1));
            //统计出现1次的数值
            if (Collections.frequency(list, i)==time){list2.add(i); }
        }
        return list2;

        //System.out.println(list.size()+list.toString());




    }


    //计算去除高频王
    private ArrayList<Integer>  kill3(int [][] a,int b){

        ArrayList<Integer> list=new ArrayList<>();
        for (int i = b; i < b+7; i++) {
            for (int j = 0; j <7 ; j++) {
                list.add(a[i][j]);

            }
        }

        Collections.sort(list);//默认排序(从小到大)

        // System.out.println(list.size()+list.toString());

        ArrayList<Integer> list2=new ArrayList();

        for (int i = 1; i <=49; i++) {
            //System.out.println((i+1)+"="+ Collections.frequency(list, i+1));
            //统计出现2次的数值
            if (Collections.frequency(list, i)>=3){list2.add(i); }
        }
        return list2;

        //System.out.println(list.sizelist.toString());




    }

    //计算去除低频王
    private ArrayList<Integer>  kill0(int [][] a,int b){

        ArrayList<Integer> list=new ArrayList<>();
        for (int i = b; i < b+7; i++) {
            for (int j = 0; j <7 ; j++) {
                list.add(a[i][j]);

            }
        }

        Collections.sort(list);//默认排序(从小到大)

        // System.out.println(list.size()+list.toString());

        ArrayList<Integer> list2=new ArrayList();

        for (int i = 1; i <=49; i++) {
            //System.out.println((i+1)+"="+ Collections.frequency(list, i+1));
            //统计出现2次的数值
            if (Collections.frequency(list, i)==0){list2.add(i); }
        }
        return list2;

        //System.out.println(list.size()+list.toString());




    }


//    //对比统计
//    private String  then1(int [][] a,int b){
//
//        ArrayList<Integer> list=new ArrayList<>();
//        for (int i = b; i < b+7; i++) {
//            for (int j = 0; j <7 ; j++) {
//                list.add(a[i][j]);
//
//            }
//        }
//
//        Collections.sort(list);//默认排序(从小到大)
//
//        //System.out.println(list.size()+list.toString());
//
//        ArrayList<Integer> list2=new ArrayList();
//
//        for (int i = 1; i <=49; i++) {
//            //System.out.println((i+1)+"="+ Collections.frequency(list, i+1));
//            //统计出现2次的数值
//            if (Collections.frequency(list, i)==1){list2.add(i); }
//        }
//
//
//        String ss="\n"+(b+8)+"期中";
//        for (int i = 0; i <7 ; i++) {
//
//            for (int j = 0; j <list2.size() ; j++) {
//                if (list2.get(j)==a[b+7][i]){
//                    ss+=a[b+7][i]+"-";};
//            }
//
//        }
//
//
//        return ss;
//
//        //System.out.println(list.size()+list.toString());
//
//
//
//
//    }








    //1234567=A 1..8..+7=a 横a-g竖A-G 转换1=Aa,2=Ab....49=Gg
    private ArrayList<String> setstr(ArrayList<Integer> list){
        ArrayList<String> strings=new ArrayList<>();
        String str1="",str2="";
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i)>=1&&list.get(i)<=7){str1="A";};
            if (list.get(i)>=8&&list.get(i)<=14){str1="B";};
            if (list.get(i)>=15&&list.get(i)<=21){str1="C";};
            if (list.get(i)>=22&&list.get(i)<=28){str1="D";};
            if (list.get(i)>=29&&list.get(i)<=35){str1="E";};
            if (list.get(i)>=36&&list.get(i)<=42){str1="F";};
            if (list.get(i)>=43&&list.get(i)<=49){str1="G";};

            if (list.get(i)%7==0){str2="g";}
            if (list.get(i)%7==1){str2="a";}
            if (list.get(i)%7==2){str2="b";}
            if (list.get(i)%7==3){str2="c";}
            if (list.get(i)%7==4){str2="d";}
            if (list.get(i)%7==5){str2="e";}
            if (list.get(i)%7==6){str2="f";}

            strings.add(str1+str2);

        }


        return strings;
    }

    //获取数据进行处理  a数组 b数组起点 c传入算法1-2返回不同数组
    private ArrayList<String> getstr(int[][] a, int b,int c){
        String str = "";
        ArrayList<String> strings=setstr(get49(a,b));;//数组0开始，连续获取49个数

        ArrayList<String> chars1=new ArrayList<>();
        ArrayList<String> chars2=new ArrayList<>();
        for (int i = 0; i < strings.size(); i++) {

            chars1.add(String.valueOf(strings.get(i).charAt(0)));
            chars2.add(String.valueOf(strings.get(i).charAt(1)));
        }

        String AG[]={"A","B","C","D","E","F","G"};
        String ag[]={"a","b","c","d","e","f","g"};
        ArrayList<Nums> numAG=new ArrayList<>();
        ArrayList<Nums> numag=new ArrayList<>();

        for (int i = 0; i < 7; i++) {
            numAG.add(new Nums(AG[i],Collections.frequency(chars1, AG[i])));
            numag.add(new Nums(ag[i],Collections.frequency(chars2, ag[i])));
        }

        Collections.sort(numAG);//从低到高出现的次数排序
        Collections.sort(numag);//从低到高出现的次数排序
//        for(Nums nums:numAG){
//            System.out.println(nums.getString()+"--"+nums.getTime());
//        }
//        for(Nums nums:numag){
//            System.out.println(nums.getString()+"--"+nums.getTime());
//        }

        ArrayList<String>strs=new ArrayList<>();

        if (c==1){
            for (int i = 0; i <numAG.size() ; i++)  {
                for (int j = 0; j < numag.size(); j++) {
                    if (numAG.get(i).getTime()>numag.get(j).getTime()){
                        strs.add(numAG.get(i).getString()+numag.get(j).getString());
                    }
                }
            }


        }
        if (c==2){
            //strs.add(numAG.get(0).getString()+numag.get(0).getString());
            // strs.add(numAG.get(0).getString()+numag.get(1).getString());
            //  strs.add(numAG.get(0).getString()+numag.get(2).getString());

//                for (int i = 0; i <numAG.size() ; i++)  {
//                    for (int j = 0; j < numag.size(); j++) {
//                        if (numAG.get(i).getTime()<numag.get(j).getTime()){
//                            strs.add(numAG.get(i).getString()+numag.get(j).getString());
//                        }
//                    }
//                }


        }


        // ArrayList<String>strs2=new ArrayList<>();
        //  strs2.addAll(0,strs);//合并起来
        ArrayList<String> newList = new ArrayList<String>(new TreeSet<String>(strs));//去重并且按照自然顺序排列

        //   System.out.println("--"+stoi(newList).toString());


        return newList;
    }

    private ArrayList<Integer> stoi(ArrayList<String> str){
        ArrayList<Integer> integers=new ArrayList<>();
        for (int i = 0; i <str.size() ; i++) {
            if (str.get(i).equals("Aa")){integers.add(1);}
            if (str.get(i).equals("Ab")){integers.add(2);}
            if (str.get(i).equals("Ac")){integers.add(3);}
            if (str.get(i).equals("Ad")){integers.add(4);}
            if (str.get(i).equals("Ae")){integers.add(5);}
            if (str.get(i).equals("Af")){integers.add(6);}
            if (str.get(i).equals("Ag")){integers.add(7);}
            if (str.get(i).equals("Ba")){integers.add(8);}
            if (str.get(i).equals("Bb")){integers.add(9);}
            if (str.get(i).equals("Bc")){integers.add(10);}
            if (str.get(i).equals("Bd")){integers.add(11);}
            if (str.get(i).equals("Be")){integers.add(12);}
            if (str.get(i).equals("Bf")){integers.add(13);}
            if (str.get(i).equals("Bg")){integers.add(14);}
            if (str.get(i).equals("Ca")){integers.add(15);}
            if (str.get(i).equals("Cb")){integers.add(16);}
            if (str.get(i).equals("Cc")){integers.add(17);}
            if (str.get(i).equals("Cd")){integers.add(18);}
            if (str.get(i).equals("Ce")){integers.add(19);}
            if (str.get(i).equals("Cf")){integers.add(20);}
            if (str.get(i).equals("Cg")){integers.add(21);}
            if (str.get(i).equals("Da")){integers.add(22);}
            if (str.get(i).equals("Db")){integers.add(23);}
            if (str.get(i).equals("Dc")){integers.add(24);}
            if (str.get(i).equals("Dd")){integers.add(25);}
            if (str.get(i).equals("De")){integers.add(26);}
            if (str.get(i).equals("Df")){integers.add(27);}
            if (str.get(i).equals("Dg")){integers.add(28);}
            if (str.get(i).equals("Ea")){integers.add(29);}
            if (str.get(i).equals("Eb")){integers.add(30);}
            if (str.get(i).equals("Ec")){integers.add(31);}
            if (str.get(i).equals("Ed")){integers.add(32);}
            if (str.get(i).equals("Ee")){integers.add(33);}
            if (str.get(i).equals("Ef")){integers.add(34);}
            if (str.get(i).equals("Eg")){integers.add(35);}
            if (str.get(i).equals("Fa")){integers.add(36);}
            if (str.get(i).equals("Fb")){integers.add(37);}
            if (str.get(i).equals("Fc")){integers.add(38);}
            if (str.get(i).equals("Fd")){integers.add(39);}
            if (str.get(i).equals("Fe")){integers.add(40);}
            if (str.get(i).equals("Ff")){integers.add(41);}
            if (str.get(i).equals("Fg")){integers.add(42);}
            if (str.get(i).equals("Ga")){integers.add(43);}
            if (str.get(i).equals("Gb")){integers.add(44);}
            if (str.get(i).equals("Gc")){integers.add(45);}
            if (str.get(i).equals("Gd")){integers.add(46);}
            if (str.get(i).equals("Ge")){integers.add(47);}
            if (str.get(i).equals("Gf")){integers.add(48);}
            if (str.get(i).equals("Gg")){integers.add(49);}

        }

        return integers;
    };

    //获取49个数为一组
    private  ArrayList<Integer>  get49(int [][] a,int b){

        ArrayList<Integer> list=new ArrayList<>();
        for (int i = b; i < b+7; i++) {
            for (int j = 0; j <7 ; j++) {
                list.add(a[i][j]);

            }
        }

        Collections.sort(list);//默认排序(从小到大)


        return list;

        //System.out.println(list.size()+list.toString());




    }




}
