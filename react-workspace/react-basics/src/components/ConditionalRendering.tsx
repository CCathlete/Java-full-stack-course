import React, { JSX, useState } from 'react';
export const ConditionalRendering = (): JSX.Element =>
{

  const [isLoggedIn, setIsLoggedIn]: [boolean, CallableFunction] =
    useState( false );

  // const Component = (): JSX.Element =>
  // {
  //   if ( isLoggedIn )
  //   {
  //     return <p>Welcome, user!</p>;
  //   }
  //   else
  //   {
  //     return <p>Please log in.</p>;
  //   }
  // };

  const handleLogIn = (): void =>
  {
    setIsLoggedIn( true );
  };

  const handleLogOut = (): void =>
  {
    setIsLoggedIn( false );
  };

  return (
    <div>
      <h1>Conditional Rendering Example</h1>
      {/* <Component /> */ }
      {
        // A ternary operation, if isLoggedIn is true, then welcome 
        // user, else please log in.
        isLoggedIn ? <p>Hemlo user!</p> : <p>Please log in.</p>
      }
      <button onClick={ handleLogIn }>Log In</button>
      <button onClick={ handleLogOut }>Log Out</button>
    </div>
  );
};