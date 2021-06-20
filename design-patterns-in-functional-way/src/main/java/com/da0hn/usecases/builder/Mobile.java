package com.da0hn.usecases.builder;

/**
 * @author daohn
 * @since 20/06/2021
 */
record Mobile(
  Integer ram,
  Integer storage,
  Integer battery,
  Integer camera,
  String processor,
  Double screenSize
) {

  public Mobile(MobileBuilder builder) {
    this(
      builder.getRam(),
      builder.getStorage(),
      builder.getBattery(),
      builder.getCamera(),
      builder.getProcessor(),
      builder.getScreenSize()
    );
  }

  @Override public String toString() {
    return String.format(
      "Specifications - RAM: %d Storage: %d Battery: %d Camera %d Processor: %s Display: %f''",
      this.ram, this.storage, this.battery, this.camera, this.processor, this.screenSize
    );
  }
}
