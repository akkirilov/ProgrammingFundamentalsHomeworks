import React, { Component } from 'react';

import Input from './fragments/Input';
import Button from './fragments/Button';

export default class Form extends Component {

    constructor(props) {
        super(props);
        this.state = {
            inputs: [],
            button: null
        }
        
    }

    componentDidMount() {
        this.setState({
            inputs: this.props.inputs.map((x, i) =>  <Input key={i} text={x.text} type={x.type} func={x.changeFunc} name={x.name} />),
            button: <Button text={this.props.button.text} type={this.props.button.type} func={this.props.button.submitFunc}/>
        });
    }

    render() {
        return (
            <div>
                <h2>{this.props.text}</h2>
            <form>
                {this.state.inputs}
                <br />
                {this.state.button}
            </form>
                <br />
                {this.props.link ? <a href={this.props.link.href} onClick={this.props.link.func}>{this.props.link.text}</a> : ''}
            </div>
        );
    };
}
