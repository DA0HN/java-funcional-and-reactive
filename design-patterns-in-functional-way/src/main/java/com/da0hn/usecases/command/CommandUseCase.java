package com.da0hn.usecases.command;

/**
 * @author daohn
 * @since 20/06/2021
 */
class CommandUseCase {

  public static void main(String[] args) {
    var ac1 = new AC();
    var ac2 = new AC();

    var remote = new ACAutomationRemote();

    remote.setCommand(ac2::turnOn); // () -> ac2.turnOn()

    remote.buttonPressed();
  }

}
