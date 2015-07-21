package com.example.firstdemo;
import android.widget.LinearLayout;
import android.view.*;
import android.widget.TextView;
import android.widget.ImageView;
import java.util.*;
import android.content.*;
import android.util.*;
import com.example.firstdemo.util.GlobalUtils;

public class BottomMenuLayout extends LinearLayout {
	//ʵ����layoutʹ�õ���    
		private LayoutInflater mInflater;     

		//����˵���ť�ļ��ϣ�ÿһ������Ԫ�ش���һ����ť�������˰�ť����Ҫ����Ϣ��ͼƬ�����֣����������¼���
		private List<BottomButton> bottomButtons;    
		
		//��װ�˵���ť�Ĳ��֡�
		private View bottomMenuLayout;   
		
		/**
		 * ��ֵ��Ҫ���ݰ�ť����ͼƬ��������
		 */
		public static final int bottom_layoutHeight = 65;
		
		public BottomMenuLayout(Context context) 
		{
			super(context);
		}
		
		public BottomMenuLayout(Context context, AttributeSet attrs) 
		{
			super(context, attrs);
		}
		
		public void processInitButton()
		{
			//��ʼ�����֣����ײ��˵�layout���뵽��ͼ�С�
			initLayout(this.getContext());    
			
			//��ÿһ���˵���ť
			bindingButton();                  

			//���¼����������ֵĴ�С��ʹ��������Ļ�ĸ߶ȼ�ȥ�ײ��˵��ĸ߶ȣ�
			//�ó��������м�ҳ�沿�ֵĸ߶ȣ����ܹ����˵��̶��ڵײ���
			resizeLayout();                   
		}

		private void initLayout(Context context)
		{
			this.mInflater = LayoutInflater.from(context);
			bottomMenuLayout = mInflater.inflate(R.layout.bottom_view, null);
			addView(bottomMenuLayout);
		}
		
		private void resizeLayout()
		{
			View customView = getChildAt(0);
			
			android.view.ViewGroup.LayoutParams params = customView.getLayoutParams();
			int screenHeight = GlobalUtils.getInstance().getScreenHeight();
			
			int lessHeight = screenHeight ;
			params.height = lessHeight;
			customView.setLayoutParams(params);
		}

		private void bindingButton() {
			LinearLayout buttonGroup = (LinearLayout)findViewById(R.id.bottom_menu_button_group_id);
			
			//��ʼ���ײ��˵���ť��
			LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
			LayoutParams layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
			if(this.bottomButtons != null && this.bottomButtons.size() > 0)
			{
				//���ݰ�ť�������㰴ť��ռ�Ŀ�ȣ�Ĭ��Ҫ���һ�����˵���ťһ���㡣
				//��ȡ��Ļ���
				int screenWidth = GlobalUtils.getInstance().getScreenWidth();
				layoutParams.width = (screenWidth / bottomButtons.size())-30;
				
				//��ÿһ����ť
				for (int i = 0; i < bottomButtons.size(); i++) 
				{
					BottomButton oneButton = bottomButtons.get(i);
					
					//��ȡ�ײ��˵���ť����Ƭ�Ρ� 
					View buttonFrameInstance = mInflater.inflate(R.layout.bottom_menu_button_frame, null);
					TextView templateText = (TextView)buttonFrameInstance.findViewById(R.id.bottom_menu_template_text_id);
					templateText.setText(oneButton.getText());
					//templateText.setBackgroundResource(oneButton.getBackgroundResource());
					
					ImageView templateImg = (ImageView)buttonFrameInstance.findViewById(R.id.bottom_menu_template_img_id);
					templateImg.setImageResource(oneButton.getBackgroundResource());
					
					//������ǵ�һ����ť������Ҫ���ӷָ���
					if(i != 0)
					{
						ImageView fenge = new ImageView(buttonFrameInstance.getContext());
						fenge.setImageResource(R.drawable.line);
						fenge.setLayoutParams(params);
						buttonGroup.addView(fenge);
					}
					
					//����ť���ӵ��˵���
					buttonGroup.addView(buttonFrameInstance);
					
					
					//���ü����¼���
					buttonFrameInstance.setOnClickListener(oneButton.getClickListener());
					
					
					//���ð�ť�����Ŀ�Ⱥͱ���ͼƬ
					LinearLayout templateButtonLayout = (LinearLayout)buttonFrameInstance.findViewById(R.id.bottom_menu_template_button_id);
					templateButtonLayout.setLayoutParams(layoutParams);
					if(oneButton.isCurrent())
						templateButtonLayout.setBackgroundResource(R.drawable.tab_two_highlight);
					else
						templateButtonLayout.setBackgroundResource(R.drawable.tab_one_normal);
				}
			}
			
			
		}
		
		
		public void setButtonList(List<BottomButton> bottomButtons)
		{
			this.bottomButtons = bottomButtons;
		}
	
	
}
