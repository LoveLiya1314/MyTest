/******************************************************************************
 * VIDI VINI VIKI                                                             *
 * Copyright ©  12:46 2021 -1 -10  Lambert All rights reserved.               *
 *    Licensed under the Apache License, Version 2.0 (the "License");         *
 *    you may not use this file except in compliance with the License.        *
 *    You may obtain a copy of the License at                                 *
 *                                                                            *
 *      http://www.apache.org/licenses/LICENSE-2.0                            *
 *                                                                            *
 *    Unless required by applicable law or agreed to in writing, software     *
 *    distributed under the License is distributed on an "AS IS" BASIS,       *
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.*
 *    See the License for the specific language governing permissions and     *
 *    limitations under the License.                                          *
 * Love Liya Forever!                                                         *
 ******************************************************************************/

package TestCode;

public class test1 extends test2{
    public static void main(String[] args) {
        int aa=First.a;
        System.out.println(aa);
    }

}
interface First{
    int a=10;
    default void fun(){

    }
}