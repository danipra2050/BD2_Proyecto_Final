import React, {useState} from 'react';
import { Button, Form, InputGroup, FormControl, Dropdown, DropdownButton, ButtonGroup, Stack, Row, Col, Container } from 'react-bootstrap';

const Services = () => {
	const [inputNombre, cambiarInputNombre] = useState('');
	const [inputCorreo, cambiarInputCorreo] = useState('');

	// Funcion que se encargara de validar los datos y enviar el formulario
	const handleSubmit = (e) => {
		e.preventDefault();

		// Comprobamos validacion del formulario ...
		// Si todo es correcto enviamos el formulario

		console.log('Formulario Enviado!');
	}

	// Funcion que se encarga de cambiar el estado del inputNombre
	const handleInputNombre = (e) => {
		cambiarInputNombre(e.target.value);
	}
	
	// Funcion que se encarga de cambiar el estado del inputCorreo
	const handleInputCorreo = (e) => {
		cambiarInputCorreo(e.target.value);
	}

	return (

<Container>
  <Row>
    <Col>
      <Form.Control size="lg" type="text" placeholder="Nombre del paciente" />
        <Form.Group controlId="formFile" className="mb-3">
          <Form.Label>Adjuntar Foto del paciente</Form.Label>
          <Form.Control type="file" />
        </Form.Group>
      <Form.Control size="lg" type="text" placeholder="Número de microchip" />
      <Form.Group controlId="formFile" className="mb-3">
        <Form.Label>Adjuntar Microchip</Form.Label>
        <Form.Control type="file" />
      </Form.Group>

    </Col>


    <Col>
    
    </Col>


    <Col>
    
        <ButtonGroup>
          <DropdownButton as={ButtonGroup} title="Especie" id="bg-nested-dropdown">
            <Dropdown.Item eventKey="1">Canino</Dropdown.Item>
            <Dropdown.Item eventKey="2">Felino</Dropdown.Item>
            <Dropdown.Item eventKey="3">Otro</Dropdown.Item>
          </DropdownButton>
        </ButtonGroup>

        <ButtonGroup>
          <DropdownButton as={ButtonGroup} title="Estado reproductivo" id="bg-nested-dropdown">
            <Dropdown.Item eventKey="1">Entero</Dropdown.Item>
            <Dropdown.Item eventKey="2">Esterilizado</Dropdown.Item>
            <Dropdown.Item eventKey="3">En gestación</Dropdown.Item>
            <Dropdown.Item eventKey="3">Lactante</Dropdown.Item>
          </DropdownButton>
        </ButtonGroup>
    
    </Col>

  </Row>
</Container>

	);
}
 
export default Services;