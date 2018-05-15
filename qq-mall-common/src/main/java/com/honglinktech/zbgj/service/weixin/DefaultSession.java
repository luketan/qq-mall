package com.honglinktech.zbgj.service.weixin;

import com.honglinktech.zbgj.service.weixin.handle.DefaultGetMsgHandle;
import com.honglinktech.zbgj.service.weixin.msg.*;
import com.honglinktech.zbgj.service.weixin.util.Config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DefaultSession extends Session {

	private List<HandleMessageListener> listeners = new ArrayList<HandleMessageListener>(3);
	private WeiXinInfo weiXininfo;


	public WeiXinInfo getWeiXininfo() {
		return weiXininfo;
	}

	public void setWeiXininfo(WeiXinInfo weiXininfo) {
		this.weiXininfo = weiXininfo;
	}

	private DefaultSession() {
	}

	public static void processGet(WeiXinInfo weixinInfo) throws IOException {
		new DefaultSession().addOnHandleMessageListener(new DefaultGetMsgHandle()).doGet(weixinInfo);
	}

	public static void processPost(WeiXinInfo weixinInfo) throws IOException {
		new DefaultSession().addOnHandleMessageListener(Config.handers).process(weixinInfo);
	}

	public DefaultSession addOnHandleMessageListener(
			HandleMessageListener handleMassge) {
		handleMassge.setWeiXinSession(this);
		listeners.add(handleMassge);
		return this;
	}

	public DefaultSession addOnHandleMessageListener(
			Class<HandleMessageListener>[] handleMassge) {
		for (Class<HandleMessageListener> handleMassgeIns : handleMassge) {
			try {
				this.addOnHandleMessageListener(handleMassgeIns.newInstance());
			} catch (Throwable e) {
				System.out.println("cant resourve hander: "
						+ handleMassgeIns.toString() + " with exception:"
						+ e.toString());
				this.onException(e);
			}
		}
		return this;
	}

	public void removeOnHandleMessageListener(HandleMessageListener handleMassge) {
		listeners.remove(handleMassge);
	}

	@Override
	public void onTextMsg(TextMsg msg) {
		for (HandleMessageListener currentListener : listeners) {
			if (currentListener.onTextMsg(msg)) {
				return;
			}
		}
	}

	public void onImageMsg(ImageMsg msg) {
		for (HandleMessageListener currentListener : listeners) {
			if (currentListener.onImageMsg(msg)) {
				return;
			}
		}
	}

	public void onEventMsg(EventMsg msg) {
		for (HandleMessageListener currentListener : listeners) {
			if (currentListener.onEventMsg(msg)) {
				return;
			}
		}
	}

	public void onLinkMsg(LinkMsg msg) {
		for (HandleMessageListener currentListener : listeners) {
			if (currentListener.onLinkMsg(msg)) {
				return;
			}
		}
	}

	public void onLocationMsg(LocationMsg msg) {
		for (HandleMessageListener currentListener : listeners) {
			if (currentListener.onLocationMsg(msg)) {
				return;
			}
		}
	}

	public void onErrorMsg(int errorCode) {
		for (HandleMessageListener currentListener : listeners) {
			if (currentListener.onErrorMsg(errorCode)) {
				return;
			}
		}
	}

	public void onVoiceMsg(VoiceMsg msg) {
		for (HandleMessageListener currentListener : listeners) {
			if (currentListener.onVoiceMsg(msg)) {
				return;
			}
		}
	}

	public void onVideoMsg(VideoMsg msg) {
		for (HandleMessageListener currentListener : listeners) {
			if (currentListener.onVideoMsg(msg)) {
				return;
			}
		}
	}

	@Override
	public void onInterfaceValidata()  {
		// TODO Auto-generated method stub
		for (HandleMessageListener currentListener : listeners) {
			if (currentListener.onInterfaceValidata()) {
				return;
			}
		}
	}

	@Override
	public void onGetToken() {
		// TODO Auto-generated method stub
		for (HandleMessageListener currentListener : listeners) {
			if (currentListener.onGetToken()) {
				return;
			}
		}
	}

	@Override
	public void onGetJsTicket() {
		// TODO Auto-generated method stub
		for (HandleMessageListener currentListener : listeners) {
			if (currentListener.onGetJsTicket()) {
				return;
			}
		}
	}

	@Override
	public void init(WeiXinInfo weiXininfo) {
		this.weiXininfo = weiXininfo;
	}

	@Override
	public void onDestory() throws Throwable {
		// if(serviceSession!=null&&
		// serviceSession.isTransactions()){
		// // serviceSession.commit();
		// }
	}

	@Override
	public void onException(Throwable e) {
		e.printStackTrace();
		// TODO Auto-generated method stub
		// if(this.resourceProvider!=null){
		// this.resourceProvider.log(e);
		// }
	}

	public void log(String message) {
		System.out.println("message=" + message);
		// if(this.resourceProvider!=null){
		// this.resourceProvider.log(message);
		// }
	}

	public String getPagingItemURI(Integer id, String format) {
		// if(this.controller!=null){
		// return StringHelper.format(format,
		// this.resourceProvider.getResource(ConfigureProvider.class)).replace("#id#",
		// id+"");
		// }
		return format.replace("#id#", id + "");
	}

	public String getFileUrlByCode(String fileCode, String rootPath) {
		// if(this.resourceProvider!=null){
		// FileStore fileStore=
		// this.resourceProvider.getResource(FileStore.class);
		// FileInformation
		// fileInformation=fileStore.getFileInformation(fileCode);
		// if (fileInformation == null) {
		// return "";
		// }
		// String requestURL=request.getRequestURL().toString();
		// requestURL=requestURL.replace(request.getRequestURI(), "");
		// try
		// {
		// requestURL="http://"
		// +getResourceProvider().getResource(ConfigureProvider.class).format(SystemVariable.SITE_DOMAIN);
		// }
		// catch (Exception e)
		// {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		//
		// StringBuilder url = new StringBuilder();
		// url.append(requestURL)
		// .append(rootPath).append(fileStore.getUploadURI())
		// .append('/').append(fileInformation.getType()).append('/')
		// .append(fileInformation.getYear()).append('/')
		// .append(fileInformation.getMonth()).append('/')
		// .append(fileInformation.getDay()).append('/')
		// .append(fileInformation.getId());
		// String subffix = fileInformation.getSuffix();
		// if (!StringUtils.isEmpty(subffix)) {
		// url.append('.').append(subffix);
		// }
		// return url.toString();
		// }
		return "";
	}
}
