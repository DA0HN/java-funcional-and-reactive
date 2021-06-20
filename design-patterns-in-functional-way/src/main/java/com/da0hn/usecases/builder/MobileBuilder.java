package com.da0hn.usecases.builder;

import java.util.function.Consumer;

/**
 * @author daohn
 * @since 20/06/2021
 */
class MobileBuilder {

  private Integer ram;
  private Integer storage;
  private Integer battery;
  private Integer camera;
  private String processor;
  private Double screenSize;

  public MobileBuilder with(Consumer<MobileBuilder> build) {
    build.accept(this);
    return this;
  }

  public Mobile create() {
    return new Mobile(this);
  }

  public Integer getCamera() {
    return camera;
  }

  public Integer getRam() {
    return ram;
  }

  public Integer getStorage() {
    return storage;
  }

  public Integer getBattery() {
    return battery;
  }

  public String getProcessor() {
    return processor;
  }

  public Double getScreenSize() {
    return screenSize;
  }

  public void setRam(Integer ram) {
    this.ram = ram;
  }

  public void setStorage(Integer storage) {
    this.storage = storage;
  }

  public void setBattery(Integer battery) {
    this.battery = battery;
  }

  public void setCamera(Integer camera) {
    this.camera = camera;
  }

  public void setProcessor(String processor) {
    this.processor = processor;
  }

  public void setScreenSize(Double screenSize) {
    this.screenSize = screenSize;
  }
}
