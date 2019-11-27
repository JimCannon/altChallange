import React from 'react';
import { ListGroup } from 'react-bootstrap';

export default function Car (props){
  return(
    <ListGroup horizontal style={{justifyContent: "center"}}>
      <ListGroup.Item style={{width: "8rem"}}>{props.car.regNr}</ListGroup.Item>
      <ListGroup.Item style={{width: "15rem"}}>{props.car.vehicleId }</ListGroup.Item>
      <ListGroup.Item style={{width: "8rem"}}>{props.car.parked? "Yes" : "No"}</ListGroup.Item>
    </ListGroup>
  )
}