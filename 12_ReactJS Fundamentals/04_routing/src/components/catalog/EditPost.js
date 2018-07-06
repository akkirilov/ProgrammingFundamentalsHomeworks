import React, { Component } from 'react';
import { Redirect } from 'react-router-dom';

import '../../styles/submit.css';
import '../../styles/comments.css';

import WithNotifications from '../../hocs/WithNotifications'
import requester from '../../infrastructure/requesterFetch';

class EditPostBase extends Component {

    constructor(props) {
        super(props);
        this.state = {
            isSubmited: false,
            postData: {},
            view: null
        }

        this.handleSubmit = this.handleSubmit.bind(this);
        this.handleChange = this.handleChange.bind(this);
    }

    componentDidMount() {
        if (sessionStorage.getItem('username')) {
            requester.get('appdata', 'posts/' + this.props.match.params.id, '')
            .then(postData => postData.json())
            .then(postData => {
                this.setState({ postData });
            })
        } else {
            this.setState({ view: <Redirect to="/"/> });
        }
        
    }

    handleSubmit(event) {
        event.preventDefault();
        if (this.state.postData.title < 5) {
            this.props.error('Title must be more than 5 symbols!');
            return;
        }
        if (this.state.postData.description < 5) {
            this.props.error('Description must be more than 5 symbols!');
            return;
        }
        requester.update('appdata', 'posts/' + this.state.postData._id, '', this.state.postData)
        .then(res => res.json())
        .then(res => {
            this.setState(prevState => {return {postData: {}, view: <Redirect to={'/posts/' + prevState.postData._id} />}});
        }).catch(err => this.props.error);
    }

    handleChange(event) {
        let postData = this.state.postData;
        postData[event.target.name] = event.target.value;
        this.setState({postData});
    }

    render () {
        return ( this.state.view ||
            <section id="viewSubmit">
                <div className="submitArea">
                    <h1>Submit Link</h1>
                    <p>Please, fill out the form. A thumbnail image is not required.</p>
                </div>
                <div className="submitArea formContainer">
                    <form id="submitForm" className="submitForm" method='POST'>
                        <label>Link URL:</label>
                        <input value={this.state.postData.url} name="url" type="text" onChange={this.handleChange} />
                        <label>Link Title:</label>
                        <input value={this.state.postData.title} name="title" type="text" onChange={this.handleChange} />
                        <label>Link Thumbnail Image (optional):</label>
                        <input value={this.state.postData.imageUrl} name="imageUrl" type="text" onChange={this.handleChange} />
                        <label>Comment (optional):</label>
                        <textarea name="description" onChange={this.handleChange} value={this.state.postData.description}></textarea>
                        <input id="btnSubmitPost" value="Submit" type="submit" onClick={this.handleSubmit}/>
                    </form>
                </div>
            </section>);
    }
}

const EditPost = WithNotifications(EditPostBase);

export default EditPost;
