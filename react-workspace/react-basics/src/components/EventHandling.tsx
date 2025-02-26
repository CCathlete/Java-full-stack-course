import { JSX, useState } from 'react';

export const EventHandling = (): JSX.Element =>
{

  const [count, setCount]: [number, CallableFunction] =
    useState( 0 );

  const handleClick = (): void =>
  {
    setCount( count + 1 );
  };

  const handleReset = (): void =>
  {
    setCount( 0 );
  };


  return (
    <div>
      <h1>Event Handling Example - counter.</h1>
      <p>Count: { count }</p>
      <button onClick={ handleClick }>Increment</button>
      <button onClick={ handleReset }>Reset</button>
    </div>
  );
};