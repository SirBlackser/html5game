var asteroidLoader = {
    "sprites": {
        // This spritesheet has 64 images, in a 8 by 8 grid
        // The dimensions are 1024-1024
        "../images/asteroidsSprite.png": {
            // This is the width of each image in pixels
            tile: 128,
            // The height of each image
            tileh: 128,
            // We give names to three individual images
            map: {
                a01: [0, 1],
                a02: [0, 2],
                a03: [0, 3],
                a04: [0, 4],
                a05: [0, 5],
                a06: [0, 6]



            }
        }
    }
};



//Only once
function init(){
    Crafty.load(asteroidLoader, null);
}

var asteroid;
var asteroids = [];
var player;

//Restart without reloading objects etc that are still valid
function start(){
    Crafty.init(window.innerWidth,window.innerHeight, document.getElementById('game'));


    generateAsteroid(150, 10, 64);
    asteroids.push(asteroid);
    generateAsteroid(500, 300, 64);
    asteroids.push(asteroid);
    generateAsteroid(700, 450, 64);
    asteroids.push(asteroid);
    generateAsteroid(20, 600, 64);
    asteroids.push(asteroid);

    player= Crafty.e('2D, DOM, Image, Controls')
        .attr({
            move: {
                left: false,
                right: false,
                up: false,
                down: false},
            xspeed: 0,
            yspeed: 0,
            decay: 0.995,
            x: 400,
            y: 300,
            w: 40,
            h: 40
        })
        .origin("center")
        // .color('#F00')
        .image("../images/ship.svg")
        .bind("KeyDown", function(e){
            //on keydown, set the move booleans
            if(e.keyCode === Crafty.keys.RIGHT_ARROW) {
                this.move.right = true;
            } else if(e.keyCode === Crafty.keys.LEFT_ARROW) {
                this.move.left = true;
            } else if(e.keyCode === Crafty.keys.UP_ARROW) {
                this.move.up = true;
            } else if (e.keyCode === Crafty.keys.SPACE) {
                console.log("Blast");
                //create a bullet entity
                Crafty.e("2D, DOM, Color")
                    .attr({
                        x: this._x+20,
                        y: this._y+20,
                        w: 2,
                        h: 5,
                        rotation: this._rotation,
                        xspeed: 20 * Math.sin(this._rotation / 57.3),
                        yspeed: 20 * Math.cos(this._rotation / 57.3)
                    })
                    .color("rgb(0,0,0)")
                    .bind("EnterFrame", function() {
                        this.x += this.xspeed;
                        this.y -= this.yspeed;

                        //destroy if it goes out of bounds
                        if(this._x > Crafty.viewport.width || this._x < 0 || this._y > Crafty.viewport.height || this._y < 0) {
                            this.destroy();
                        }
                    })
                    .checkHits(asteroids);
            }
        }).bind("KeyUp", function(e) {
            //on key up, set the move booleans to false
            if(e.keyCode === Crafty.keys.RIGHT_ARROW) {
                this.move.right = false;
            } else if(e.keyCode === Crafty.keys.LEFT_ARROW) {
                this.move.left = false;
            } else if(e.keyCode === Crafty.keys.UP_ARROW) {
                this.move.up = false;
            }
        }).bind("EnterFrame", function() {
            if(this.move.right) this.rotation += 4;
            if(this.move.left) this.rotation -= 4;

            //acceleration and movement vector
            var vx = Math.sin(this._rotation * Math.PI / 180) * 0.3,
                vy = Math.cos(this._rotation * Math.PI / 180) * 0.3;

            //if the move up is true, increment the y/xspeeds
            if(this.move.up) {
                this.yspeed -= vy;
                this.xspeed += vx;
            } else {
                //if released, slow down the ship
                this.xspeed *= this.decay;
                this.yspeed *= this.decay;
            }

            //move the ship by the x and y speeds or movement vector
            this.x += this.xspeed;
            this.y += this.yspeed;

            //if ship goes out of bounds, put him back
            if(this._x > Crafty.viewport.width) {
                this.x = -64;
            }
            if(this._x < -64) {
                this.x =  Crafty.viewport.width;
            }
            if(this._y > Crafty.viewport.height) {
                this.y = -64;
            }
            if(this._y < -64) {
                this.y = Crafty.viewport.height;
            }

        });
}

function generateAsteroid(x, y, size){

    asteroid = Crafty.e(getRandomAsteroid())
            .attr({x:x, y:y, w:size, h:size,
                speed: Math.random()*5,
                xDir: Math.random(),
                yDir: Math.random()})
            .bind("EnterFrame", function(){
                this.x += this.xDir*this.speed;
                this.y += this.yDir*this.speed;

                //if ship goes out of bounds, put him back
                if(this._x > Crafty.viewport.width) {
                    this.x = -64;
                }
                if(this._x < -64) {
                    this.x =  Crafty.viewport.width;
                }
                if(this._y > Crafty.viewport.height) {
                    this.y = -64;
                }
                if(this._y < -64) {
                    this.y = Crafty.viewport.height;
                }
            });

}

function getRandomAsteroid(){
    var s;

    switch (Math.floor(Math.random()*10)) {
        case 0: s = "2D, Canvas, a01";
            break;
        case 1: s = "2D, Canvas, a02";
            break;
        case 2: s = "2D, Canvas, a03";
            break;
        case 3: s = "2D, Canvas, a04";
            break;
        case 4: s = "2D, Canvas, a05";
            break;
        default:
            s = "2D, Canvas, a06";
            break;
    }
    return s;
}

init();
start();

//Reset Game
window.onresize = function(event) {
    Crafty.init(window.innerWidth,window.innerHeight, document.getElementById('game'));
};