package com.yanis.yc_ui_qzone;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;

public class MainActivity extends FragmentActivity implements OnClickListener {
	// ����Fragmentҳ��
	private FragmentAt fragmentAt;
	private FragmentAuth fragmentAuth;
	private FragmentSpace fragmentSpace;
	private FragmentMore fragmentMore;
	// ���岼�ֶ���
	private FrameLayout atFl, authFl, spaceFl, moreFl;

	// ����ͼƬ�������
	private ImageView atIv, authIv, spaceIv, moreIv;

	// ���尴ťͼƬ���
	private ImageView toggleImageView, plusImageView;

	// ����PopupWindow
	private PopupWindow popWindow;
	// ��ȡ�ֻ���Ļ�ֱ��ʵ���
	private DisplayMetrics dm;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initView();

		initData();

		// ��ʼ��Ĭ��Ϊѡ�е���ˡ���̬����ť
		clickAtBtn();
	}

	/**
	 * ��ʼ�����
	 */
	private void initView() {
		// ʵ�������ֶ���
		atFl = (FrameLayout) findViewById(R.id.layout_at);
		authFl = (FrameLayout) findViewById(R.id.layout_auth);
		spaceFl = (FrameLayout) findViewById(R.id.layout_space);
		moreFl = (FrameLayout) findViewById(R.id.layout_more);

		// ʵ����ͼƬ�������
		atIv = (ImageView) findViewById(R.id.image_at);
		authIv = (ImageView) findViewById(R.id.image_space);
		spaceIv = (ImageView) findViewById(R.id.image_space);
		moreIv = (ImageView) findViewById(R.id.image_more);

		// ʵ������ťͼƬ���
		toggleImageView = (ImageView) findViewById(R.id.toggle_btn);
		plusImageView = (ImageView) findViewById(R.id.plus_btn);

	}

	/**
	 * ��ʼ������
	 */
	private void initData() {
		// �����ֶ������ü���
		atFl.setOnClickListener(this);
		authFl.setOnClickListener(this);
		spaceFl.setOnClickListener(this);
		moreFl.setOnClickListener(this);

		// ����ťͼƬ���ü���
		toggleImageView.setOnClickListener(this);
	}

	/**
	 * ����¼�
	 */
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		// �����̬��ť
		case R.id.layout_at:
			clickAtBtn();
			break;
		// ���������ذ�ť
		case R.id.layout_auth:
			clickAuthBtn();
			break;
		// ����ҵĿռ䰴ť
		case R.id.layout_space:
			clickSpaceBtn();
			break;
		// ������ఴť
		case R.id.layout_more:
			clickMoreBtn();
			break;
		// ����м䰴ť
		case R.id.toggle_btn:
			clickToggleBtn();
			break;
		}
	}

	/**
	 * ����ˡ���̬����ť
	 */
	private void clickAtBtn() {
		// ʵ����Fragmentҳ��
		fragmentAt = new FragmentAt();
		// �õ�Fragment���������
		FragmentTransaction fragmentTransaction = this
				.getSupportFragmentManager().beginTransaction();
		// �滻��ǰ��ҳ��
		fragmentTransaction.replace(R.id.frame_content, fragmentAt);
		// ��������ύ
		fragmentTransaction.commit();
		// �ı�ѡ��״̬
		atFl.setSelected(true);
		atIv.setSelected(true);

		authFl.setSelected(false);
		authIv.setSelected(false);

		spaceFl.setSelected(false);
		spaceIv.setSelected(false);

		moreFl.setSelected(false);
		moreIv.setSelected(false);
	}

	/**
	 * ����ˡ�������ء���ť
	 */
	private void clickAuthBtn() {
		// ʵ����Fragmentҳ��
		fragmentAuth = new FragmentAuth();
		// �õ�Fragment���������
		FragmentTransaction fragmentTransaction = this
				.getSupportFragmentManager().beginTransaction();
		// �滻��ǰ��ҳ��
		fragmentTransaction.replace(R.id.frame_content, fragmentAuth);
		// ��������ύ
		fragmentTransaction.commit();

		atFl.setSelected(false);
		atIv.setSelected(false);

		authFl.setSelected(true);
		authIv.setSelected(true);

		spaceFl.setSelected(false);
		spaceIv.setSelected(false);

		moreFl.setSelected(false);
		moreIv.setSelected(false);
	}

	/**
	 * ����ˡ��ҵĿռ䡱��ť
	 */
	private void clickSpaceBtn() {
		// ʵ����Fragmentҳ��
		fragmentSpace = new FragmentSpace();
		// �õ�Fragment���������
		FragmentTransaction fragmentTransaction = this
				.getSupportFragmentManager().beginTransaction();
		// �滻��ǰ��ҳ��
		fragmentTransaction.replace(R.id.frame_content, fragmentSpace);
		// ��������ύ
		fragmentTransaction.commit();

		atFl.setSelected(false);
		atIv.setSelected(false);

		authFl.setSelected(false);
		authIv.setSelected(false);

		spaceFl.setSelected(true);
		spaceIv.setSelected(true);

		moreFl.setSelected(false);
		moreIv.setSelected(false);
	}

	/**
	 * ����ˡ����ࡱ��ť
	 */
	private void clickMoreBtn() {
		// ʵ����Fragmentҳ��
		fragmentMore = new FragmentMore();
		// �õ�Fragment���������
		FragmentTransaction fragmentTransaction = this
				.getSupportFragmentManager().beginTransaction();
		// �滻��ǰ��ҳ��
		fragmentTransaction.replace(R.id.frame_content, fragmentMore);
		// ��������ύ
		fragmentTransaction.commit();

		atFl.setSelected(false);
		atIv.setSelected(false);

		authFl.setSelected(false);
		authIv.setSelected(false);

		spaceFl.setSelected(false);
		spaceIv.setSelected(false);

		moreFl.setSelected(true);
		moreIv.setSelected(true);
	}

	/**
	 * ������м䰴ť
	 */
	private void clickToggleBtn() {
		showPopupWindow(toggleImageView);
		// �ı䰴ť��ʾ��ͼƬΪ����ʱ��״̬
		plusImageView.setSelected(true);
	}

	/**
	 * �ı���ʾ�İ�ťͼƬΪ����״̬
	 */
	private void changeButtonImage() {
		plusImageView.setSelected(false);
	}

	/**
	 * ��ʾPopupWindow�����˵�
	 */
	private void showPopupWindow(View parent) {
		if (popWindow == null) {
			LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

			View view = layoutInflater.inflate(R.layout.popwindow_layout, null);
			dm = new DisplayMetrics();
			getWindowManager().getDefaultDisplay().getMetrics(dm);
			// ����һ��PopuWidow����
			popWindow = new PopupWindow(view, dm.widthPixels, LinearLayout.LayoutParams.WRAP_CONTENT); 
		}
		// ʹ��ۼ� ��Ҫ������˵���ؼ����¼��ͱ���Ҫ���ô˷���
		popWindow.setFocusable(true);
		// ����������������ʧ
		popWindow.setOutsideTouchable(true);
		// ���ñ����������Ϊ�˵��������Back��Ҳ��ʹ����ʧ�����Ҳ�����Ӱ����ı���
		popWindow.setBackgroundDrawable(new BitmapDrawable());
		// PopupWindow����ʾ��λ������
		// popWindow.showAtLocation(parent, Gravity.FILL, 0, 0);
		popWindow.showAsDropDown(parent, 0,0);

		popWindow.setOnDismissListener(new OnDismissListener() {
			@Override
			public void onDismiss() {
				// �ı���ʾ�İ�ťͼƬΪ����״̬
				changeButtonImage();
			}
		});

		// ���������¼�
		popWindow.setTouchInterceptor(new OnTouchListener() {
			public boolean onTouch(View view, MotionEvent event) {
				// �ı���ʾ�İ�ťͼƬΪ����״̬
				changeButtonImage();
				popWindow.dismiss();
				return false;
			}
		});
	}
}
