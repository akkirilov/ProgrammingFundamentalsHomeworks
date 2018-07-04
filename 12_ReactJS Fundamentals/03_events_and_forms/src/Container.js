import React, { Component } from 'react';

import Form from './forms/Form';

export default class Container extends Component {

    constructor(props) {
        super(props);
        this.state = {
            pokemonsView: null,
            token: '',
            user: {},
            errors: {},
            message: null,
            success: null,
            session: {},
            isLoggedIn: false,
            pokemons: [],
            loginForm: null,
            registerForm: null, 
            pokemonForm: null,
            activeForm: null,
            pokemonData: {},
            loginData: {}, 
            registerData: {}
        }

        this.getRegister = this.getRegister.bind(this);
        this.getLogin = this.getLogin.bind(this);
        this.changePokemon = this.changePokemon.bind(this);
        this.changeLogin = this.changeLogin.bind(this);
        this.changeRegister = this.changeRegister.bind(this);
        this.handlePokemon = this.handlePokemon.bind(this);
        this.handleLogin = this.handleLogin.bind(this);
        this.handleRegister = this.handleRegister.bind(this);
    }

    getPokemonForm() {
        return  <Form text="POKEMON FORM" 
            inputs={[{type:'text', text:'Pokemon name: ', name: 'pokemonName', changeFunc:this.changePokemon}, {type:'text', text:'Pokemon image: ', name: 'pokemonImg', changeFunc:this.changePokemon}, {type:'text', text:'Pokemon info: ', name: 'pokemonInfo', changeFunc:this.changePokemon}]} 
            button={{text:'Add Pokemon', type: 'submit', submitFunc: this.handlePokemon}}/>;
    }

    componentDidMount() {
        let loginForm = <Form key="login" 
            link={{href: '/register', text: 'Registration', func: this.getRegister}} text="LOGIN FORM" 
            inputs={[{type:'text', text:'Email: ', name: 'email', changeFunc:this.changeLogin}, {type:'password', text:'Password: ', name: 'password', changeFunc:this.changeLogin}]} 
            button={{text:'Login', type: 'submit', submitFunc: this.handleLogin}}/>;
        let registerForm = <Form key="register" 
            link={{href: '/login', text: 'Login', func: this.getLogin}} text="REGISTER FORM" 
            inputs={[{type:'text', text:'Email: ', name: 'email', changeFunc:this.changeRegister}, {type:'text', text:'Username: ', name: 'name', changeFunc:this.changeRegister}, {type:'password', text:'Password: ', name: 'password', changeFunc:this.changeRegister}, {type:'password', text:'Password confirm: ', name: 'passwordConfirm', changeFunc:this.changeRegister}]} 
            button={{text:'Register', type: 'submit', submitFunc: this.handleRegister}}/>;
        let pokemonForm = this.getPokemonForm();
        this.setState({activeForm: loginForm, loginForm, registerForm, pokemonForm, isLoggedIn: false});
    }

    getRegister(event) {
        event.preventDefault();
        this.setState(prevState => ({activeForm: prevState.registerForm, loginData: {}}));
    }

    getLogin(event) {
        event.preventDefault();
        this.setState(prevState => ({activeForm: prevState.loginForm, registerData: {}, errors:{}, message:"", isLoggedIn: false}));
    }

    changePokemon(event) {
        event.preventDefault();
        let pokemonData = this.state.pokemonData;
        pokemonData[event.target.name] = event.target.value;
        this.setState({ pokemonData });
    }

    changeLogin(event) {
        event.preventDefault();
        let loginData = this.state.loginData;
        loginData[event.target.name] = event.target.value;
        this.setState({ loginData });
    }

    changeRegister(event) {
        event.preventDefault();
        let registerData = this.state.registerData;
        registerData[event.target.name] = event.target.value;
        this.setState({ registerData });
    }

    handlePokemon(event) {
        event.preventDefault();
        if (!this.state.isLoggedIn) {
            this.setState({errors: {user: "You need to be logged in to post new pokemon!"}, activeForm: this.state.loginForm});
            return;
        }
        fetch('http://localhost:5000/pokedex/create', {
            method: 'post',
            headers: {'Content-Type':'application/json'},
            body: JSON.stringify(this.state.pokemonData)
        });
        this.setState(prevState => { 
            return {
            pokemons: [...prevState.pokemons, prevState.pokemonData],
            pokemonData: {},
            pokemonForm: this.getPokemonForm(),
            activeForm: <Form text="POKEMON FORM" 
            inputs={[{type:'text', text:'Pokemon name: ', name: 'pokemonName', changeFunc:this.changePokemon}, {type:'text', text:'Pokemon image: ', name: 'pokemonImg', changeFunc:this.changePokemon}, {type:'text', text:'Pokemon info: ', name: 'pokemonInfo', changeFunc:this.changePokemon}]} 
            button={{text:'Add Pokemon', type: 'submit', submitFunc: this.handlePokemon}}/>
        }});
    }

    handleLogin(event) {
        event.preventDefault();
        fetch('http://localhost:5000/auth/login', {
            method: 'post',
            headers: {'Content-Type':'application/json'},
            body: JSON.stringify(this.state.loginData)
        })
        .then(data => data.json())
        .then(data => {
            let errors = data.errors || {};
            if (!data.success) {
                this.setState({
                    message: data.message, 
                    success: data.success, 
                    errors: errors
                });
                return;
            } 
            this.setState({
                    message: data.message, 
                    success: data.success, 
                    errors: errors, 
                    loginData: {},
                    isLoggedIn: true,
                    token: data.token, 
                    user: data.user,
                    activeForm: this.state.pokemonForm
                });
                fetch('http://localhost:5000/pokedex/pokedex')
                .then(data => data.json())
                .then(data => (this.setState(prev => {return {pokemons: data.pokemonColection}})))
        });
    }

    handleRegister(event) {
        event.preventDefault();
        fetch('http://localhost:5000/auth/signup', {
            method: 'post',
            headers: {'Content-Type':'application/json'},
            body: JSON.stringify(this.state.registerData)
        })
        .then(data => data.json())
        .then(data => {
            let errors = data.errors || {};
            if (data.success) {
                this.setState({message: data.message, success: data.success, errors: errors, registerData: {}, activeForm: this.state.loginForm});
            } else {
                this.setState({message: data.message, success: data.success, errors: errors});
            }
        });
    }

    render() {
        return (
            <div>
            <div>{this.state.message}</div>
            <div><ul>{Object.keys(this.state.errors).map((x, i) => <li key={i}>{this.state.errors[x]}</li>)}</ul></div>
            <div>{this.state.success}</div>
            {this.state.activeForm}
            <div>
                {this.state.pokemons.map((data, i)=>(<div key={i} className="pokemon"><div><img alt="pokemon" src={data.pokemonImg} /><div>{data.pokemonName}</div><div>{data.pokemonInfo}</div></div></div>))}
            </div>
            </div>
        );
    };
}