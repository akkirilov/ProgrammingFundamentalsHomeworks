import React, { Component } from 'react';

import LoginForm from '../user/LoginForm';
import RegisterForm from '../user/RegisterForm';
import About from '../static/About';

class Home extends Component {

    render() {
        return (
            <section id="viewWelcome">
                <div className="welcome">
                    <div className="signup">
                    <LoginForm />
                    <RegisterForm />
                    </div>
                    <About />
                </div>
            </section>
        );
    }

}

export default Home;
