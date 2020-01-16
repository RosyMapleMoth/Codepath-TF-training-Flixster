# Codepath-TF-training-Flixster
Flix
Flix is an app that allows users to browse movies from the [The Movie Database API](http://docs.themoviedb.apiary.io/#).

## Flix Part 2

### User Stories

#### REQUIRED (10pts)

- [x] (8pts) Expose details of movie (ratings using RatingBar, popularity, and synopsis) in a separate activity.
- [x] (2pts) Allow video posts to be played in full-screen using the YouTubePlayerView.

#### BONUS

- [x] *sort of I made it open the video on the same page rather then having to open a new activity to view this video* Trailers for popular movies are played automatically when the movie is selected (1 point).
  - [ ] When clicking on a popular movie (i.e. a movie voted for more than 5 stars) the video should be played immediately.
  - [ ] Less popular videos rely on the detailed page should show an image preview that can initiate playing a YouTube video.
- [x] *do to the nature of how i show popular movies this is already included by the youtube player* Add a play icon overlay to popular movies to indicate that the movie can be played (1 point).
- [x] Apply the popular ButterKnife annotation library to reduce view boilerplate. (1 point)
- [x] Add a rounded corners for the images using the Glide transformations. (1 point)

### App Walkthough GIF

TODO add img
<img src="YOUR_GIF_URL_HERE" width=250><br>

### Notes
I had a great deal of trouble when attempting the follow the guide on shaired element transitions, to the point that i gave up on it temporaraly I hope to attmept it at a later date, other then that i had a few issues understanding how to get activitys and contexts to the adaptor class, however this issue was fairly easy to overcome.

## Open-source libraries used
- [Android Async HTTP](https://github.com/codepath/CPAsyncHttpClient) - Simple asynchronous HTTP requests with JSON parsing
- [Glide](https://github.com/bumptech/glide) - Image loading and caching library for Android
---

## Flix Part 1

### User Stories

#### REQUIRED (10pts)
- [x] (10pts) User can view a list of movies (title, poster image, and overview) currently playing in theaters from the Movie Database API.

#### BONUS
- [x] (2pts) Views should be responsive for both landscape/portrait mode.
   - [x] (1pt) In portrait mode, the poster image, title, and movie overview is shown.
   - [x] (1pt) In landscape mode, the rotated alternate layout should use the backdrop image instead and show the title and movie overview to the right of it.

- [x] (2pts) Display a nice default [placeholder graphic](https://guides.codepath.org/android/Displaying-Images-with-the-Glide-Library#advanced-usage) for each image during loading
- [x] (2pts) Improved the user interface by experimenting with styling and coloring.
- [ ] (2pts) For popular movies (i.e. a movie voted for more than 5 stars), the full backdrop image is displayed. Otherwise, a poster image, the movie title, and overview is listed. Use Heterogenous RecyclerViews and use different ViewHolder layout files for popular movies and less popular ones.

### App Walkthough GIF
<img src="https://i.imgur.com/AKdI52W.gif" width=250><br>
<img src="https://i.imgur.com/HgPiBYb.gif" height=250><br>

### Notes
I ran in to a few issues 
   1. was a commen one where the app dosn't have internet permissions, i found the codepath hint actually lead me in the wrong directions, as it implied that the app wouldn't crash with out internet permission, but mine did.
   2. during the glide implimentation of a placeholder image was a bit more challenging then initally while making the Generated API i ran  in to some odd bugs, such as one of my classes give the error "this class is a duplicit" however all of this resolved by just restarting android studio.
   3. I also had a bit of making a useable drawable, but this came with time and doing a slight amount of reserch out side of the codepath site.

### Open-source libraries used

- [Android Async HTTP](https://github.com/codepath/CPAsyncHttpClient) - Simple asynchronous HTTP requests with JSON parsing
- [Glide](https://github.com/bumptech/glide) - Image loading and caching library for Androids
