package com.da0hn.usecases.command;

/**
 * @author daohn
 * @since 20/06/2021
 */
class ACAutomationRemote {

  private Command command;

  public void setCommand(Command command) {
    this.command = command;
  }

  public void buttonPressed() {
    command.execute();
  }
}
