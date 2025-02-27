import { JSX } from "react";

export interface StudentProps
{
  name: string;
  age: number;
  email: string;
}

export const Student = ( props: StudentProps ): JSX.Element =>
{
  return (
    <div>
      <p>Name: { props.name }</p>
      <p>Age: { props.age }</p>
      <p>Email: { props.email }</p>
    </div>
  );
};