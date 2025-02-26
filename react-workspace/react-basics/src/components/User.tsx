import { useState, JSX } from "react";

export interface UserProps
{
  firstName: string;
  lastName: string;
  email: string;
}

export const User = ( props: UserProps ): JSX.Element =>
{
  const [user, setUser]: [UserProps, CallableFunction] = useState( props );

  const testData: UserProps = {
    firstName: "First",
    lastName: "Last",
    email: "Email",
  };

  const updateUser = (): void =>
  {
    setUser( testData );
  };


  return (
    <div>
      <pre style={ { textAlign: "left" } }>
        User:{ '\n' }
        { JSON.stringify( user, null, 2 ) }
      </pre>
      <button onClick={ updateUser }>Update user</button>
    </div>
  );
};