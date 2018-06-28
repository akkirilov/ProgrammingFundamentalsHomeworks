import React from 'react';
import fetcher from '../../fetcher';

const IMAGE_URL = '/episodePreview/';

export default class Slider extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            id: null,
            url: null
        }
    }
    componentDidMount = () => {
        fetcher.get(IMAGE_URL + 0, (data) => this.setState({url: data.url, id: data.id}));
    }

    getNextEpisode = () => {
        fetcher.get(IMAGE_URL + (this.state.id + 1), (data) => this.setState({url: data.url, id: data.id}));
    }

    getPrevEpisode = () => {
        fetcher.get(IMAGE_URL + (this.state.id - 1), (data) => this.setState({url: data.url, id: data.id}));
    }

    render = () => (
            <section id="slider">
                <img className="button" src="/left.png" title="previous" alt="nav" onClick={this.getPrevEpisode}/>
                <div className="image-container">
                    <img src={this.state.url} alt="episode" />
                </div>
                <img className="button" src="/right.png" title="next" alt="nav" onClick={this.getNextEpisode}/>
            </section>
        );
}