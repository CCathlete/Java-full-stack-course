import React, { JSX } from "react";

type greetingProps =
  {
    name: string;
  };

class Greeting extends React.Component<greetingProps, {}>
{

  constructor ( props: greetingProps )
  {
    super( props );
  }
  render(): React.ReactNode
  {
    return <h2>Hi { this.props.name },
      this is my greeting class!</h2>;
  }
}

export { Greeting };