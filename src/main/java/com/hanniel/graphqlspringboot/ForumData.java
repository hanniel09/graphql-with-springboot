package com.hanniel.graphqlspringboot;

record Post(String id, String content) {
}

record Comment(String id, String content, String postId){

}
