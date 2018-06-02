package com.honglinktech.zbgj.entity;

import com.honglinktech.zbgj.bean.GoodsPhoneBean;
import com.honglinktech.zbgj.vo.GoodsPhoneVO;

import java.util.Date;

/**
 * Created by Administrator on 2018/5/23.
 */
public class GoodsPhone {
    /**
     *
     */
    private Integer id;

    /**
     * 型号
     */
    private String model;

    /**
     * 手机IMEI
     */
    private String imei;

    /**
     * 维修次数
     */
    private Integer repair;

    /**
     * 内存
     */
    private Integer ram;

    /**
     * 前摄像头
     */
    private String frontCamera;

    /**
     * 后摄像头
     */
    private String afterCamera;

    /**
     * 电池容量
     */
    private String battery;

    /**
     * 电池效率
     */
    private String batteryEffe;

    /**
     * 充电次数
     */
    private String batteryNum;

    /**
     * cpu
     */
    private String cpu;

    /**
     * cpu频率
     */
    private String cpuFreq;

    /**
     * 颜色
     */
    private String color;

    /**
     * 成色
     */
    private Integer quality;

    /**
     * 版本
     */
    private String version;

    /**
     * 系统版本
     */
    private String systemVersion;

    /**
     * 网络
     */
    private String net;

    /**
     * sim卡规格
     */
    private String sim;

    /**
     * 屏幕尺寸
     */
    private String screenSize;

    /**
     * 尺寸
     */
    private String size;

    /**
     * 分辨率
     */
    private String resolution;

    /**
     * 更新时间
     */
    private Date generateTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public Integer getRepair() {
        return repair;
    }

    public void setRepair(Integer repair) {
        this.repair = repair;
    }

    public Integer getRam() {
        return ram;
    }

    public void setRam(Integer ram) {
        this.ram = ram;
    }

    public String getFrontCamera() {
        return frontCamera;
    }

    public void setFrontCamera(String frontCamera) {
        this.frontCamera = frontCamera;
    }

    public String getAfterCamera() {
        return afterCamera;
    }

    public void setAfterCamera(String afterCamera) {
        this.afterCamera = afterCamera;
    }

    public String getBattery() {
        return battery;
    }

    public void setBattery(String battery) {
        this.battery = battery;
    }

    public String getBatteryEffe() {
        return batteryEffe;
    }

    public void setBatteryEffe(String batteryEffe) {
        this.batteryEffe = batteryEffe;
    }

    public String getBatteryNum() {
        return batteryNum;
    }

    public void setBatteryNum(String batteryNum) {
        this.batteryNum = batteryNum;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getCpuFreq() {
        return cpuFreq;
    }

    public void setCpuFreq(String cpuFreq) {
        this.cpuFreq = cpuFreq;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getQuality() {
        return quality;
    }

    public void setQuality(Integer quality) {
        this.quality = quality;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getSystemVersion() {
        return systemVersion;
    }

    public void setSystemVersion(String systemVersion) {
        this.systemVersion = systemVersion;
    }

    public String getNet() {
        return net;
    }

    public void setNet(String net) {
        this.net = net;
    }

    public String getSim() {
        return sim;
    }

    public void setSim(String sim) {
        this.sim = sim;
    }

    public String getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(String screenSize) {
        this.screenSize = screenSize;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public Date getGenerateTime() {
        return generateTime;
    }

    public void setGenerateTime(Date generateTime) {
        this.generateTime = generateTime;
    }

    public GoodsPhone() {
    }

    public GoodsPhone(GoodsPhoneBean goodsPhoneBean) {
        this.id = goodsPhoneBean.getId();
        this.model = goodsPhoneBean.getModel();
        this.imei = goodsPhoneBean.getImei();
        this.repair = goodsPhoneBean.getRepair();
        this.ram = goodsPhoneBean.getRam();
        this.frontCamera = goodsPhoneBean.getFrontCamera();
        this.afterCamera = goodsPhoneBean.getAfterCamera();
        this.battery = goodsPhoneBean.getBattery();
        this.batteryEffe = goodsPhoneBean.getBatteryEffe();
        this.batteryNum = goodsPhoneBean.getBatteryNum();
        this.cpu = goodsPhoneBean.getCpu();
        this.cpuFreq = goodsPhoneBean.getCpuFreq();
        this.color = goodsPhoneBean.getColor();
        this.quality = goodsPhoneBean.getQuality();
        this.version = goodsPhoneBean.getVersion();
        this.systemVersion = goodsPhoneBean.getSystemVersion();
        this.net = goodsPhoneBean.getNet();
        this.sim = goodsPhoneBean.getSim();
        this.screenSize = goodsPhoneBean.getScreenSize();
        this.size = goodsPhoneBean.getSize();
        this.resolution = goodsPhoneBean.getResolution();
        this.generateTime = goodsPhoneBean.getGenerateTime();
    }

    public GoodsPhoneVO toVO(){
        GoodsPhoneVO goodsPhoneVO = new GoodsPhoneVO();
        goodsPhoneVO.setId(this.id);
        goodsPhoneVO.setModel(this.model);
        goodsPhoneVO.setImei(this.imei);
        goodsPhoneVO.setRepair(this.repair);
        goodsPhoneVO.setRam(this.ram);
        goodsPhoneVO.setFrontCamera(this.frontCamera);
        goodsPhoneVO.setAfterCamera(this.afterCamera);
        goodsPhoneVO.setBattery(this.battery);
        goodsPhoneVO.setBatteryEffe(this.batteryEffe);
        goodsPhoneVO.setBatteryNum(this.batteryNum);
        goodsPhoneVO.setCpu(this.cpu);
        goodsPhoneVO.setCpuFreq(this.cpuFreq);
        goodsPhoneVO.setColor(this.color);
        goodsPhoneVO.setQuality(this.quality);
        goodsPhoneVO.setVersion(this.version);
        goodsPhoneVO.setSystemVersion(this.systemVersion);
        goodsPhoneVO.setNet(this.net);
        goodsPhoneVO.setSim(this.sim);
        goodsPhoneVO.setScreenSize(this.screenSize);
        goodsPhoneVO.setSize(this.size);
        goodsPhoneVO.setResolution(this.resolution);
        goodsPhoneVO.setGenerateTime(this.generateTime);
        return goodsPhoneVO;
    }

    public GoodsPhoneBean toBean(){
        GoodsPhoneBean goodsPhoneBean = new GoodsPhoneBean();
        goodsPhoneBean.setId(this.id);
        goodsPhoneBean.setModel(this.model);
        goodsPhoneBean.setImei(this.imei);
        goodsPhoneBean.setRepair(this.repair);
        goodsPhoneBean.setRam(this.ram);
        goodsPhoneBean.setFrontCamera(this.frontCamera);
        goodsPhoneBean.setAfterCamera(this.afterCamera);
        goodsPhoneBean.setBattery(this.battery);
        goodsPhoneBean.setBatteryEffe(this.batteryEffe);
        goodsPhoneBean.setBatteryNum(this.batteryNum);
        goodsPhoneBean.setCpu(this.cpu);
        goodsPhoneBean.setCpuFreq(this.cpuFreq);
        goodsPhoneBean.setColor(this.color);
        goodsPhoneBean.setQuality(this.quality);
        goodsPhoneBean.setVersion(this.version);
        goodsPhoneBean.setSystemVersion(this.systemVersion);
        goodsPhoneBean.setNet(this.net);
        goodsPhoneBean.setSim(this.sim);
        goodsPhoneBean.setScreenSize(this.screenSize);
        goodsPhoneBean.setSize(this.size);
        goodsPhoneBean.setResolution(this.resolution);
        goodsPhoneBean.setGenerateTime(this.generateTime);
        return goodsPhoneBean;
    }

}
