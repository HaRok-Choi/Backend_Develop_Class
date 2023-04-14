import { Dispatch, SetStateAction } from 'react'

interface Props {
    label: string;
    type: string;
    name: string;
    setter: Dispatch<SetStateAction<string>>;
    maxLength: number;
    iconClass: string;
}

export default function NaverInput(props: Props) {
    const { label, type, name, maxLength, iconClass, setter } = props;

    return (
        <div className="input-row">/.
            <div className="icon-cell">
                <span className={iconClass}>
                    <span className="blind">{label}</span>
                </span>
            </div>
            <input
                type={type}
                className="input-text"
                maxLength={maxLength}
                placeholder={label}
                name={name}
                onChange={(event) => setter(event.target.value)}
            // onChange는 event라는 결과물을 내준다. 사용자가 변경하는 타겟의 밸류로 설정함
            // input의 값이 바뀔때마다 {}안의 함수를 호출함
            />
        </div>
    );
}
