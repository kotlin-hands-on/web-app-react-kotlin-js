import kotlinx.css.*
import react.*
import react.dom.div
import react.dom.h3
import react.dom.img
import styled.css
import styled.styledDiv
import styled.styledH1

interface AppState: RState {
    var currentVideo: Video?
}

class App: RComponent<RProps, AppState>() {
    override fun RBuilder.render() {
        styledH1 {
            css {
                fontFamily = "sans-serif"
            }
            +"KotlinConf Explorer"
        }
        div {
            h3 {
                +"Videos to watch"
            }
            videoList {
                videos = unwatchedVideos
                selectedVideo = state.currentVideo
                onSelectVideo = { video ->
                    setState {
                        currentVideo = video
                    }
                }
            }

            h3 {
                +"Videos watched"
            }
            videoList {
                videos = watchedVideos
                selectedVideo = state.currentVideo
                onSelectVideo = { video ->
                    setState {
                        currentVideo = video
                    }
                }
            }
        }
        styledDiv {
            css {
                position = Position.absolute
                top = 10.px
                right = 10.px
            }
            h3 {
                +"John Doe: Building and breaking things"
            }
            img {
                attrs {
                    src = "https://via.placeholder.com/640x360.png?text=Video+Player+Placeholder"
                }
            }
        }
    }
}