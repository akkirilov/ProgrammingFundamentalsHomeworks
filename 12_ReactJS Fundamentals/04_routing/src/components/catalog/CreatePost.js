import React, { Component } from 'react';
import { Redirect } from 'react-router-dom';

import '../../styles/submit.css';
import '../../styles/comments.css';

import WithNotifications from '../../hocs/WithNotifications'
import requester from '../../infrastructure/requesterFetch';

class CreatePostBase extends Component {

    constructor(props) {
        super(props);
        this.state = {
            postData: {},
            view: null
        }

        this.handleSubmit = this.handleSubmit.bind(this);
        this.handleChange = this.handleChange.bind(this);
    }

    componentDidMount() {
        let view = <Redirect to="/" />;
        if (sessionStorage.getItem('username')) {
            view = (
            <section id="viewSubmit">
                <div className="submitArea">
                    <h1>Submit Link</h1>
                    <p>Please, fill out the form. A thumbnail image is not required.</p>
                </div>
                <div className="submitArea formContainer">
                    <form id="submitForm" className="submitForm" method='POST'>
                        <label>Link URL:</label>
                        <input name="url" type="text" onChange={this.handleChange} />
                        <label>Link Title:</label>
                        <input name="title" type="text" onChange={this.handleChange} />
                        <label>Link Thumbnail Image (optional):</label>
                        <input name="imageUrl" type="text" onChange={this.handleChange} />
                        <label>Comment (optional):</label>
                        <textarea name="description" onChange={this.handleChange}></textarea>
                        <input id="btnSubmitPost" value="Submit" type="submit" onClick={this.handleSubmit}/>
                    </form>
                </div>
            </section>);
        }
        this.setState({ view });
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
        let data = this.state.postData;
        data.author = sessionStorage.getItem('username');
        requester.post('appdata', 'posts', '', data)
        .then(res => res.json())
        .then(res => {
            this.props.info('Successfully added new post!');
            this.setState({postData: {}, view: <Redirect to="/catalog"/>});
        }).catch(err => this.props.error);
    }

    handleChange(event) {
        let postData = this.state.postData;
        postData[event.target.name] = event.target.value;
        this.setState({postData});
    }

    render () {
        return this.state.view
    }
}

const CreatePost = WithNotifications(CreatePostBase);

export default CreatePost;
