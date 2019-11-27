import React from 'react';
import Car from './Car';
import { Accordion, Card, ListGroup } from 'react-bootstrap';

export default function Company (props){
  return (
    <Accordion defaultActiveKey="0">
      <Card>
        <Accordion.Toggle as={Card.Header} eventKey="0">
          {props.company.companyName}
        </Accordion.Toggle>
        <Accordion.Collapse eventKey="0">
          <Card.Body>
              <ListGroup horizontal style={{justifyContent: "center"}}>
              <ListGroup.Item style={{width: "8rem"}}>regnr</ListGroup.Item>
              <ListGroup.Item style={{width: "15rem"}}>vehicleId</ListGroup.Item>
              <ListGroup.Item style={{width: "8rem"}}>parkerad</ListGroup.Item>
              </ListGroup>
              {props.company.carList.map(car => 
                <Car key={car.id}car={car}/>
              )}    
          </Card.Body>
        </Accordion.Collapse>
      </Card>
    </Accordion>
    
  )
}