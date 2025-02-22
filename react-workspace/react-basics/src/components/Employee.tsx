import React, { JSX } from "react";

export interface EmployeeProps
{
  name: string;
  email: string;
  position: string;
}

// This time we pass in props and a state.
export class Employee extends React.Component<EmployeeProps, EmployeeProps>
{
  another_field: string = "This is another field";

  constructor ( props: EmployeeProps )
  {
    super( props );

    this.state = props;
    // Not needed when it's an arrow.
    // this.updateEmployee = this.updateEmployee.bind( this );
  }

  private updateEmployee = (): void =>
  {
    this.setState(
      {
        name: "Goobly",
        email: "gooblygoobly@example.com",
        position: "Goobler",
      }
    );
  };

  render(): JSX.Element
  {
    return (
      <div>
        <p>Name (from state): { this.state.name }</p>
        <p>Position (from props): { this.props.position }</p>
        <p>Another (from an additional field): { this.another_field }</p>

        <button onClick={ this.updateEmployee }>Update Employee</button>
        <p>Now the position is: { this.state.position }</p>
      </div>

    );
  }

}