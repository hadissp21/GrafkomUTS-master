#version 330

//uniform vec4 uni_color; // ada di frag
out vec4 fragColor;
in vec4 out_color; // pastikan sama dengan vert

void main(){
    //rgba -> xxx/255
    //fragColor = vec4(1.0f, 0.0f, 0.0f, 1.0f);
    fragColor = out_color;
}