import { useState, JSX } from "react";

interface UserProps
{
  firstName: string;
  lastName: string;
  email: string;
}

export const User = ( props: UserProps ): JSX.Element =>
{
  const [user, setUser]: [UserProps, CallableFunction] = useState( props );

  const updateUser = (): void =>
  {
    setUser( { firstName: "first" } );
  };


  return (
    <div>

    </div>
  );
};