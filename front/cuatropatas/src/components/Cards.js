import React from 'react';
import './Cards.css';
import CardItem from './CardItem';

function Cards() {
  return (
    <div className='cards'>
      <h1>Adopta y cambíale la vida a ellos</h1>
      <div className='cards__container'>
        <div className='cards__wrapper'>
          <ul className='cards__items'>
            <CardItem
              src='images/img-9.jpg'
              text='Un adoptado siempre te agradecerá'
              label='Adopta'
              path='/services'
            />
            <CardItem
              src='images/img-2.jpg'
              text='Te brindan amor incondicional'
              label='Más que amor'
              path='/services'
            />
          </ul>
          <ul className='cards__items'>
            <CardItem
              src='images/img-3.jpg'
              text='Su amor y agradecimiento hacia ti no fallarán'
              label='Cuidará de ti'
              path='/services'
            />
            <CardItem
              src='images/img-4.jpg'
              text='Con una mascota tendrás infinitas aventuras'
              label='Descubre el mundo a su lado'
              path='/products'
            />
            <CardItem
              src='images/img-8.jpg'
              text='En nuestro refugio tenemos muchas mascotas que se adaptarán a ti'
              label='Desde pequeños hasta grandes'
              path='/sign-up'
            />
          </ul>
        </div>
      </div>
    </div>
  );
}

export default Cards;
