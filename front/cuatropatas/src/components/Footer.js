import React from 'react';
import './Footer.css';
import { Button } from './Button';
import { Link } from 'react-router-dom';

function Footer() {
  return (
    <div className='footer-container'>
      <section className='footer-subscription'>
        <p className='footer-subscription-heading'>
          Conoce más de nosotros
        </p>
        <p className='footer-subscription-text'>
          Comienza esta gran aventura
        </p>
        <div className='input-areas'>
          <form>
            <input
              className='footer-input'
              name='email'
              type='email'
              placeholder='Correo electrónico'
            />
            <Button buttonStyle='btn--outline'>Subscríbete</Button>
          </form>
        </div>
      </section>
      <div class='footer-links'>
        <div className='footer-link-wrapper'>
          <div class='footer-link-items'>
            <h2>Sobre nosotros</h2>
            <Link to='/sign-up'>Nuestro trabajo</Link>
            <Link to='/'>Nuestra misión</Link>
            <Link to='/'>Nuestra visión</Link>
            <Link to='/'>Nuestra fundación</Link>
          </div>
          <div class='footer-link-items'>
            <h2>Contáctanos</h2>
            <Link to='/'>Contacto</Link>
            <Link to='/'>Ayuda</Link>
          </div>
        </div>
        <div className='footer-link-wrapper'>
          <div class='footer-link-items'>
            <h2>Videos</h2>
            <a href='https://www.youtube.com/watch?v=-afTsUGUfmw&ab_channel=ClaudiaPizarro' target="_blank">¿Por qué adoptar?</a>

          </div>
          <div class='footer-link-items'>
            <h2>Redes sociales</h2>
            <a href='https://www.instagram.com/alcaldiabogota/?hl=es-la' target="_blank">Instagram</a>
            <a href='https://www.facebook.com/AlcaldiaBogota/' target="_blank">Facebook</a>
            <a href='https://www.youtube.com/alcaldiabogota' target="_blank">Youtube</a>
            <a href='https://twitter.com/bogota/?lang=es' target="_blank">Twitter</a>
          </div>
        </div>
      </div>
      <section class='social-media'>
        <div class='social-media-wrap'>
          <div class='footer-logo'>
            <Link to='/' className='social-logo'>
              <img src="https://bogota.gov.co/sites/default/files/styles/1050px/public/2019-07/bogota-mejor-para-todos.png" width="200px"></img>
            </Link>
          </div>
          <small class='website-rights'>Alcaldía de Bogotá</small>
          <div class='social-icons'>
            <a 
              href="https://www.facebook.com/AlcaldiaBogota/"
              class='social-icon-link facebook'
              target='_blank'
              aria-label='Facebook'
            >
              <i class='fab fa-facebook-f' />
            </a>
            <a
              href="https://www.instagram.com/alcaldiabogota/?hl=es-la"
              class='social-icon-link instagram'
              target='_blank'
              aria-label='Instagram'
            >
              <i class='fab fa-instagram' />
            </a>
            <a
              href="https://www.youtube.com/alcaldiabogota"
              class='social-icon-link youtube'
              target='_blank'
              aria-label='Youtube'
            >
              <i class='fab fa-youtube' />
            </a>
            <a
              href="https://twitter.com/bogota/?lang=es"
              class='social-icon-link twitter'
              target='_blank'
              aria-label='Twitter'
            >
              <i class='fab fa-twitter' />
            </a>
          </div>
        </div>
      </section>
    </div>
  );
}

export default Footer;
