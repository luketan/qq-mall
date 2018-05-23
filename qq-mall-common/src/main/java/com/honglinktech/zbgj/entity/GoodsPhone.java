package com.honglinktech.zbgj.entity;

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
    private Integer frontCamera;

    /**
     * 后摄像头
     */
    private Integer afterCamera;

    /**
     * 电池容量
     */
    private Integer battery;

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
    private Double screenSize;

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
    private Date updateTime;

    /**
     * 创建时间
     */
    private Date createDate;

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

    public Integer getFrontCamera() {
        return frontCamera;
    }

    public void setFrontCamera(Integer frontCamera) {
        this.frontCamera = frontCamera;
    }

    public Integer getAfterCamera() {
        return afterCamera;
    }

    public void setAfterCamera(Integer afterCamera) {
        this.afterCamera = afterCamera;
    }

    public Integer getBattery() {
        return battery;
    }

    public void setBattery(Integer battery) {
        this.battery = battery;
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

    public Double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(Double screenSize) {
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

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
