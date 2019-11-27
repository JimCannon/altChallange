import React from 'react';

export default function CarList (props){

  return(
    <ul>
      {props.carList.map(c => 
        <li key={c.id}> {
            c.regNr + 
            ' | ' + 
            c.vehicleId + 
            ' | ' + 
            c.parked 
          }
        </li>
      )}
    </ul>
  )
}