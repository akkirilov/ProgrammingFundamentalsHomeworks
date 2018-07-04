import React, { Component } from 'react';

export default class LoginForm extends Component {

    render() {
        return (
            <div>
                <label>{this.props.text} </label>
                <input type={this.props.type} name={this.props.name} onChange={this.props.func}/>
            </div>
        );
    };
}
