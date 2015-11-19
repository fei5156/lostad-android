package com.lostad.applib.widget;


import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lostad.applib.R;
import com.lostad.applib.util.EffectUtil;


/******************************************************************** 
 * [Summary] 
 *       TODO 请在此处简要描述此类所实现的功能。因为这项注释主要是为了在IDE环境中生成tip帮助，务必简明扼要 
 * [Remarks] 
 *       TODO 请在此处详细描述类的功能、调用方法、注意事项、以及与其它类的关系. 
 *******************************************************************/  
  
public class CustomProgressDialog extends Dialog {  
    private static CustomProgressDialog customProgressDialog = null;
      
    public CustomProgressDialog(Context context){  
        super(context);  
    }
      
    public CustomProgressDialog(Context context, int theme) {  
        super(context, theme);  
    }  
      @Override
    protected void onCreate(Bundle savedInstanceState) {
    	setCanceledOnTouchOutside(false);
    	super.onCreate(savedInstanceState);
    }

    public static CustomProgressDialog createDialog(Context context){  
        customProgressDialog = new CustomProgressDialog(context, R.style.CustomProgressDialog);
        customProgressDialog.setContentView(R.layout.dlg_loading);
        customProgressDialog.getWindow().getAttributes().gravity = Gravity.CENTER;

        return customProgressDialog;  
    }  
   @Override
    public void onWindowFocusChanged(boolean hasFocus){  

       if (customProgressDialog == null){
            return;
       }

       ImageView imageView = (ImageView) customProgressDialog.findViewById(R.id.iv_loading);
       imageView.setImageResource(R.mipmap.loading1);
       EffectUtil.startAnimation( getContext(), imageView);
    }

    public void showSucessIcon() {

        ImageView imageView = (ImageView) customProgressDialog.findViewById(R.id.iv_loading);
        imageView.clearAnimation();
        imageView.setImageResource(R.drawable.icon_success);

    }

    /**
     *
     * [Summary]
     *       setMessage 提示内容
     * @param strMessage
     * @return
     *
     */
    public CustomProgressDialog setMessage(String strMessage){
    	TextView tvMsg = (TextView)customProgressDialog.findViewById(R.id.tv_msg);
        if (tvMsg != null){
            tvMsg.setText(strMessage);
            tvMsg.setVisibility(View.VISIBLE);
        }

        return customProgressDialog;
    }


}
