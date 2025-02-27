import { JSX } from "react";

interface WelcomeProps
{
  name: string;
}
function Welcome( { name }: WelcomeProps ): JSX.Element
{
  return <h1>Hi { name }! It's Ken :)</h1>;
}

export default Welcome;