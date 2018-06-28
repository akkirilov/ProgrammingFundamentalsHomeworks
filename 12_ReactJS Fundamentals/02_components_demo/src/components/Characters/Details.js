import React from 'react';

export default class Details extends React.Component {
    render = () => (
            <section id="bio">
                <img src={this.props.url} alt="details"/>
                <div className="padding-left-10">
                <p>Name: <strong>{this.props.name}</strong></p>
                <p>Bio: {this.props.bio}</p>
                </div>
            </section>
        );
}